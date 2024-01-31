package com.hei.wallet_spring.Repository;



import com.hei.wallet_spring.Model.Account;
import com.hei.wallet_spring.Model.Transaction;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class AccountDAO implements CrudOperations<Account> {
    private Connection connection;

    public AccountDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Account> findAll() {
        List<Account> accountList = new ArrayList<>();
        List<Transaction> transactionList = new ArrayList<>();

        String sql = "SELECT account.id idAccount, account.name AccountName, balance, updatedate, account.type AccountType ,currency , " +
                "t.id idTransaction, category, transactiondate, amount\n" +
                "from account\n" +
                "inner join transaction t on account.id = t.account";

        try (PreparedStatement statement = connection.prepareStatement(sql)){
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {

                transactionList.add(new Transaction(
                        (UUID) resultSet.getObject("idTransaction"),
                        resultSet.getTimestamp("transactiondate"),
                        resultSet.getDouble("amount"),
                        (UUID) resultSet.getObject("category"),
                        (UUID) resultSet.getObject("idAccount")
                ));

                accountList.add(new Account(
                        (UUID) resultSet.getObject("idAccount"),
                        resultSet.getString("accountName"),
                        resultSet.getDouble("balance"),
                        resultSet.getTimestamp("updatedate"),
                        transactionList,
                        resultSet.getString("AccountType"),
                        (UUID) resultSet.getObject("currency")
                ));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return accountList;
    }

    @Override
    public List<Account> saveAll(List<Account> toSave) {
        List<Account> accounts = new ArrayList<>();
        for (Account account : toSave) {
            Account savedAccount = save(account);
            if (savedAccount != null) {
                accounts.add(savedAccount);
            }

        }
        return accounts;
    }

    @Override
    public Account save(Account toSave) {
        String sql = "INSERT INTO account(id, name, balance, updateDate, type, currency) VALUES(?,?,?,?,?,?) " +
                "ON CONFLICT (id) DO UPDATE SET name=EXCLUDED.name, balance=EXCLUDED.balance, " +
                "updateDate=EXCLUDED.updateDate, type=EXCLUDED.type, currency=EXCLUDED.currency";

        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setObject(1, toSave.getId());
            statement.setString(2, toSave.getName());
            statement.setDouble(3, toSave.getBalance());
            statement.setTimestamp(4, toSave.getUpdateDate());
            statement.setString(5, toSave.getType());
            statement.setObject(6, toSave.getCurrency());

            int rowAffected = statement.executeUpdate();
            if (rowAffected > 0) {
                return toSave;
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Account delete(Account toDelete) {
        String sql = "DELETE from account where id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setObject(1, toDelete.getId());
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                return toDelete;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
