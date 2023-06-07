package com.highradius.connection;

import java.sql.*;

public class DatabaseConnector {
    public static void main(String[] args) {
        // Database connection parameters
        String url = "jdbc:mysql://localhost:3306/hrc";
        String username = "root";
        String password = "";

        // Database query
        String query = "SELECT * FROM h2h_oap";
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Establish database connection
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();

            // Execute the query
            resultSet = statement.executeQuery(query);

            // Process the result set
            while (resultSet.next()) {
                int customerOrderID = resultSet.getInt("CUSTOMER_ORDER_ID");
                System.out.println(customerOrderID);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the resources
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
