package Workshops.no4_databases;

import java.sql.*;

public class preparedStatement {

    public static void main(String[] args) {

        String address = "jdbc:postgresql://127.0.0.1:5432/zajavka";
        String dbUsername = "postgres";
        String dbPassword = "postgres";

        String username = "ntinner27";

        // SQL injection
        String badUsername = "whatever' or 1=1 or USER_NAME = 'whateverAgain";

        // do zwykłego statement
        String query1 = "DELETE FROM OPINION WHERE CUSTOMER_ID IN (SELECT ID FROM CUSTOMER WHERE USER_NAME = '" + username + "');";
        String query2 = "DELETE FROM PURCHASE WHERE CUSTOMER_ID IN (SELECT ID FROM CUSTOMER WHERE USER_NAME = '" + username + "');";
        String query3 = "DELETE FROM CUSTOMER WHERE USER_NAME = '" + username + "';";

        // do prepareStatement
        String query4 = "DELETE FROM OPINION WHERE CUSTOMER_ID IN (SELECT ID FROM CUSTOMER WHERE USER_NAME = ?');";
        String query5 = "DELETE FROM PURCHASE WHERE CUSTOMER_ID IN (SELECT ID FROM CUSTOMER WHERE USER_NAME = ?');";
        String query6 = "DELETE FROM CUSTOMER WHERE USER_NAME = ?;";

        try (
                Connection connection = DriverManager.getConnection(address, dbUsername, dbPassword);
                PreparedStatement statement1 = connection.prepareStatement(query4);
                PreparedStatement statement2 = connection.prepareStatement(query5);
                PreparedStatement statement3 = connection.prepareStatement(query6);
        ){
            statement1.setString(1, username);
            statement2.setString(1, username);
            statement3.setString(1, username);

            int count1 = statement1.executeUpdate();
            int count2 = statement2.executeUpdate();
            int count3 = statement3.executeUpdate();

            System.out.println(count1);
            System.out.println(count2);
            System.out.println(count3);

        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }
}
