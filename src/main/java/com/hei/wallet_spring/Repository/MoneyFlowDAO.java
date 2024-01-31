package com.hei.wallet_spring.Repository;



import com.hei.wallet_spring.Model.MoneyFlow;
import org.springframework.stereotype.Repository;

import java.sql.*;

import java.util.UUID;

@Repository
public class MoneyFlowDAO {
    private Connection connection;

    public MoneyFlowDAO(Connection connection) {
        this.connection = connection;
    }

    public MoneyFlow getMoneyFlowByDateRange(UUID idAccount, Date startDate, Date endDate){
        String sql = "select sum(CASE WHEN category.type = 'credit' THEN transaction.amount ELSE 0 END) TotalEntrance, " +
                "sum(CASE WHEN category.name = 'debit' THEN transaction.amount ELSE 0 END) TotalExit " +
                "from transaction " +
                "INNER JOIN category ON transaction.category = category.id " +
                "INNER JOIN type t on category.type = t.id " +
                "where account = ? " +
                "AND transaction.transactionDate BETWEEN ? AND ? ";

        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setObject(1, idAccount);
            statement.setDate(2, startDate);
            statement.setDate(3, endDate);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new MoneyFlow(
                        resultSet.getDouble("TotalEntrance"),
                        resultSet.getDouble("TotalExit")
                );
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
