package com.hei.wallet_spring.DAOTest;


import com.hei.wallet_spring.DatabaseConfiguration.DatabaseConnection;
import com.hei.wallet_spring.Model.Currency;
import com.hei.wallet_spring.Repository.CurrencyDAO;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CurrencyDAOTest {

    @Test
    void testFindAll(){
        DatabaseConnection connectionManager = new DatabaseConnection();
        try (Connection connection = connectionManager.getConnection()){
            CurrencyDAO currencyDAO = new CurrencyDAO(connection);
            if (connection != null){
                assertEquals(2,currencyDAO.findAll().size());
            }
        } catch (SQLException e) {
            System.err.println("An error occurred while fetching currencies: " + e.getMessage());
            System.out.println("Failed to retrieve currencies. Please try again later.");
        }
    }

    @Test
    void testSaveAll(){
        DatabaseConnection connectionManager = new DatabaseConnection();
        try (Connection connection = connectionManager.getConnection()){
            CurrencyDAO currencyDAO = new CurrencyDAO(connection);
            if (connection != null){
                Currency currency1 = new Currency(UUID.fromString("d7157ff1-9030-4ca6-bbbe-64bed70e6368"),"Yuan","CNY");
                Currency currency2 = new Currency(UUID.fromString("16f76bab-2299-4692-a3b9-53343837e183"),"Yen","JPY");
                List<Currency> currenciesToSave = List.of(currency1, currency2);
                assertEquals(2,currencyDAO.saveAll(currenciesToSave).size());
                for (Currency currency : currenciesToSave){
                    currencyDAO.delete(currency);
                }
            }
        } catch (SQLException e) {
            System.err.println("An error occurred while fetching currencies: " + e.getMessage());
            System.out.println("Failed to retrieve currencies. Please try again later.");
        }
    }

    @Test
    void testSave(){
        DatabaseConnection connectionManager = new DatabaseConnection();
        try (Connection connection = connectionManager.getConnection()){
            CurrencyDAO currencyDAO = new CurrencyDAO(connection);
            if (connection != null){
                Currency currency = new Currency(UUID.fromString("d7157ff1-9030-4ca6-bbbe-64bed70e6368"),"Yuan","CNY");
                Currency createdCurrency = currencyDAO.save(currency);
                assertNotNull(createdCurrency);
                currencyDAO.delete(currency);
            }
        } catch (SQLException e) {
            System.err.println("An error occurred while fetching currencies: " + e.getMessage());
            System.out.println("Failed to retrieve currencies. Please try again later.");
        }
    }

    @Test
    void testDelete() {
        DatabaseConnection connectionManager = new DatabaseConnection();
        try (Connection connection = connectionManager.getConnection()) {
            CurrencyDAO currencyDAO = new CurrencyDAO(connection);
            if (connection != null) {
                Currency currency = new Currency(UUID.fromString("d7157ff1-9030-4ca6-bbbe-64bed70e6368"), "Yuan", "CNY");
                Currency createdCurrency = currencyDAO.save(currency);
                Currency deletedCurrency = currencyDAO.delete(currency);
                assertEquals(createdCurrency, deletedCurrency);
            }
        } catch (SQLException e) {
            System.err.println("An error occurred while fetching currencies: " + e.getMessage());
            System.out.println("Failed to retrieve currencies. Please try again later.");
        }
    }
}
