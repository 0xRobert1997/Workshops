package Workshops.no4_databases;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CustomerMapper {

    public static List<Customer> mapToCustomers(ResultSet resultSet) {
        List<Customer> result = new ArrayList<>();

        try {

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
