package com.hei.wallet_spring.Repository;



import com.hei.wallet_spring.Model.Transaction;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Repository
public class TransactionDAO implements CrudOperations<Transaction>{
    private Connection connection;

    public TransactionDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Transaction> findAll() {
        List<Transaction> transactionList = new ArrayList<>();
        String sql = "SELECT * from transaction";

        try (PreparedStatement statement = connection.prepareStatement(sql)){
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                transactionList.add(new Transaction(
                        (UUID) resultSet.getObject("id"),
                        resultSet.getTimestamp("transactionDate"),
                        resultSet.getDouble("amount"),
                        (UUID) resultSet.getObject("category"),
                        (UUID) resultSet.getObject("account")
                ));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return transactionList;
    }

    @Override
    public List<Transaction> saveAll(List<Transaction> toSave) {
        List<Transaction> transactions = new ArrayList<>();
        for (Transaction transaction : toSave) {
            Transaction savedTransaction = save(transaction);
            if (savedTransaction != null) {
                transactions.add(savedTransaction);
            }

        }
        return transactions;
    }

    @Override
    public Transaction save(Transaction toSave) {
        String sql = "INSERT INTO transaction(id, transactiondate, amount, category,account) values(?,?,?,?,?)"+
                "ON CONFLICT (id) DO UPDATE SET category=EXCLUDED.category, " +
                "transactionDate=EXCLUDED.transactionDate, amount=EXCLUDED.amount, account=EXCLUDED.account";

        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setObject(1, toSave.getId());
            statement.setTimestamp(2, (toSave.getTransactionDate()));
            statement.setDouble(3, toSave.getAmount());
            statement.setObject(4, toSave.getCategory());
            statement.setObject(5, toSave.getAccount());

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
    public Transaction delete(Transaction toDelete) {
        String sql = "DELETE from transaction where id = ?";
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

    public String findTypeById(UUID id){
        String sql = "select type.name from type " +
                "INNER JOIN category c on type.id = c.type " +
                "INNER JOIN transaction t on c.id = t.category " +
                "WHERE t.id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setObject(1, id);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                return resultSet.getString("name");
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;

    }
}
