package com.hei.wallet_spring.Repository;



import com.hei.wallet_spring.DatabaseConfiguration.DatabaseConnection;
import com.hei.wallet_spring.Model.CategoryAmount;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository

public class CategoryAmountDAO {
    private final DatabaseConnection databaseConnection;

    public CategoryAmountDAO(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    public List<CategoryAmount> getCategoryAmountsByDateRangeWithZero(UUID accountId, Timestamp startDate, Timestamp endDate) {
        List<CategoryAmount> categoryAmounts = new ArrayList<>();
        try (Connection connection = databaseConnection.getConnection()) {
            if (connection != null) {
                String sql = "SELECT * FROM getCategoryAmountsByDateRangeWithZero(?, ?, ?)";
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setObject(1, accountId);
                    statement.setTimestamp(2, startDate);
                    statement.setTimestamp(3, endDate);

                    try (ResultSet resultSet = statement.executeQuery()) {
                        while (resultSet.next()) {
                            String categoryName = resultSet.getString("categoryName");
                            double totalAmount = resultSet.getDouble("totalAmount");

                            CategoryAmount categoryAmount = new CategoryAmount(categoryName, totalAmount);
                            categoryAmounts.add(categoryAmount);
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return categoryAmounts;
    }


}


