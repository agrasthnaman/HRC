package com.highradius.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.highradius.connection.DbConnection;
import com.highradius.model.POJO;

public class UserDaoImpl implements UserDAO {

    private static final String INSERT_USER_SQL = "INSERT INTO users (customerOrderID, salesOrg, distributionChannel, customerNumber, companyCode, orderCurrency, amountUSD, orderCreationDate) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SELECT_ALL_USERS_SQL = "SELECT * FROM users";
    private static final String DELETE_USER_SQL = "DELETE FROM users WHERE customerOrderID = ?";
    private static final String UPDATE_USER_SQL = "UPDATE users SET salesOrg = ?, distributionChannel = ?, customerNumber = ?, companyCode = ?, orderCurrency = ?, amountUSD = ?, orderCreationDate = ? WHERE customerOrderID = ?";

    public void insertUser(POJO user) throws SQLException {
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_SQL)) {
            preparedStatement.setInt(1, user.getCustomerOrderID());
            preparedStatement.setString(2, user.getSalesOrg());
            preparedStatement.setString(3, user.getDistributionChannel());
            preparedStatement.setInt(4, user.getCustomerNumber());
            preparedStatement.setString(5, user.getCompanyCode());
            preparedStatement.setString(6, user.getOrderCurrency());
            preparedStatement.setDouble(7, user.getAmountUSD());
            preparedStatement.setDate(8, new java.sql.Date(user.getOrderCreationDate().getTime()));

            preparedStatement.executeUpdate();
        }
    }

    public List<POJO> selectAllUsers() {
        List<POJO> users = new ArrayList<>();

        try (Connection connection = DbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS_SQL);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int customerOrderID = resultSet.getInt("customerOrderID");
                String salesOrg = resultSet.getString("salesOrg");
                String distributionChannel = resultSet.getString("distributionChannel");
                int customerNumber = resultSet.getInt("customerNumber");
                String companyCode = resultSet.getString("companyCode");
                String orderCurrency = resultSet.getString("orderCurrency");
                double amountUSD = resultSet.getDouble("amountUSD");
                java.sql.Date orderCreationDate = resultSet.getDate("orderCreationDate");

                POJO user = new POJO(customerOrderID, salesOrg, distributionChannel, customerNumber, companyCode, orderCurrency, amountUSD, orderCreationDate);
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    public boolean deleteUser(int customerOrderID) throws SQLException {
        boolean rowDeleted = false;

        try (Connection connection = DbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER_SQL)) {
            preparedStatement.setInt(1, customerOrderID);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        }

        return rowDeleted;
    }

    public boolean updateUser(POJO user) throws SQLException {
        boolean rowUpdated = false;

        try (Connection connection = DbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER_SQL)) {
            preparedStatement.setString(1, user.getSalesOrg());
            preparedStatement.setString(2, user.getDistributionChannel());
            preparedStatement.setInt(3, user.getCustomerNumber());
            preparedStatement.setString(4, user.getCompanyCode());
            preparedStatement.setString(5, user.getOrderCurrency());
            preparedStatement.setDouble(6, user.getAmountUSD());
            preparedStatement.setDate(7, new java.sql.Date(user.getOrderCreationDate().getTime()));
            preparedStatement.setInt(8, user.getCustomerOrderID());

            rowUpdated = preparedStatement.executeUpdate() > 0;
        }

        return rowUpdated;
    }
}
