package Workshops.no4_databases.resultSet;

import java.sql.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        String query = "SELECT * FROM CUSTOMER WHERE NAME LIKE ?;";
        String parameter = "%me%";

        String address = "jdbc:postgresql://127.0.0.1:5432/zajavka";
        String dbUsername = "postgres";
        String dbPassword = "postgres";

        try (
                Connection connection = DriverManager.getConnection(address, dbUsername, dbPassword);
                PreparedStatement preparedStatement = connection.prepareStatement(query)


        ) {
            preparedStatement.setString(1, parameter);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                List<Customer> customers = CustomerMapper.mapToCustomers(resultSet);
                customers.forEach(customer -> System.out.println("Customer: " + customer));
            }

        } catch (SQLException e) {
            System.out.println(e.getSQLState());
            System.out.println(e.getErrorCode());
            System.out.println(e.getMessage());


        }
    }
}
