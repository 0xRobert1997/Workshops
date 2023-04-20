package Workshops.no4_databases.resultSet;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CustomerMapper {

    public static List<Customer> mapToCustomers(ResultSet resultSet) {
        List<Customer> result = new ArrayList<>();

        try {
            while (resultSet.next()) {
                Object col1 = resultSet.getObject(1);


                result.add(new Customer(
                        // można też odwoływać się po indeksach column np .getString(1) (pierwsza kolumna na indeks 1 a nie 0
                        resultSet.getString("id"),
                        resultSet.getString("user_name"),
                        resultSet.getString("email"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getDate(6).toLocalDate(),
                        resultSet.getString("telephone_number")
                ));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
}
