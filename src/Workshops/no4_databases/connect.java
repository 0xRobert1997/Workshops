package Workshops.no4_databases;

import java.sql.*;

public class main {

    public static void main(String[] args) {

        // <protokol>:<baza_danych>://<adres_bazy_danych>/<nazwa_bazy_danych>
        // jdbc:postgresql://127.0.0.1:5432/zajavka

        String address = "jdbc:postgresql://127.0.0.1:5432/zajavka";
        String username = "postgres";
        String password = "postgres";



        try (
            Connection connection = DriverManager.getConnection(address, username, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("");
        ){
        } catch
         (Exception e) {
            System.err.println("Exception: " + e.getMessage());
        }


//           zamiast tylu trajów użyć try with ressources
//            finally {
//            try {
//                if (resultSet != null) {
//                    resultSet.close();
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//
//            try {
//                if (statement != null) {
//                    statement.close();
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//
//            try {
//                if (connection != null) {
//                    connection.close();
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }

    }
}
