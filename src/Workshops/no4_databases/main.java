package Workshops.no4_databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class main {

    public static void main(String[] args) {
        String address = "jdbc:postgresql://127.0.0.1:5432/zajavka";
        String username = "postgres";
        String password = "postgres";

        String query1 = "INSERT INTO PRODUCER (ID, PRODUCER_NAME, ADDRESS)"
                + "VALUES (8, 'Zajavka Group8', 'Zajavkowa 15, Warszawa')";
        String query2 = "UPDATE PRODUCER SET ADDRESS = 'Nowy adres siedziby' WHERE ID = 1";
        String query3 = "DELETE FROM PRODUCER WHERE ID IN (2,3,4,5)";
        String query4 = "SELECT * FROM PRODUCER";


        // execute - zwraca boolean czy jako wynik został zwrócony ResultSet (tylko SELECT zwraca)
        // executeUpdate - zwraca ilość modyfikowanych wierszy
        // executeQuery - zwraca otrzymany z zapytania z SELECT rezultat w postaci ResultSet
        try (
                Connection connection = DriverManager.getConnection(address, username, password);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query4);
        ){
            int i = statement.executeUpdate(query4);
        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }
}
