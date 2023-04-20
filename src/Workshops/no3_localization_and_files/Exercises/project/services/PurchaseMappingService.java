package Workshops.no3_localization_and_files.Exercises.project.services;

import Workshops.no3_localization_and_files.Exercises.project.domain.Car;
import Workshops.no3_localization_and_files.Exercises.project.domain.Location;
import Workshops.no3_localization_and_files.Exercises.project.domain.Person;
import Workshops.no3_localization_and_files.Exercises.project.domain.Purchase;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PurchaseMappingService {

    public static Purchase getPurchase(String inputData) {
        String[] row = inputData.split(",");
        long id = Long.parseLong(row[0]);
        String firstName = row[1];
        String lastName = row[2];
        String email = row[3];
        String ip = row[4];
        String color = row[5];
        String vin = row[6];
        String company = row[7];
        String model = row[8];
        String modelYear = row[9];
        // new BigDecimal(row[10].substring(1));
        BigDecimal price = new BigDecimal(row[10].replace("\"", "").substring(1));
        String country = row[11];
        String city = row[12];
        LocalDate purchaseDate = LocalDate.parse(row[13]);


        return new Purchase(
                id,
                new Person(firstName, lastName, email, ip),
                new Car(color, vin, company, model, modelYear, price),
                new Location(country, city),
                purchaseDate);
    }

    public static String getCsvRow(Purchase purchase) {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s",
                purchase.getId(),
                purchase.getPerson().getFirstName(),
                purchase.getPerson().getLastName(),
                purchase.getPerson().getEmail(),
                purchase.getPerson().getIp(),
                purchase.getCar().getColor(),
                purchase.getCar().getVin(),
                purchase.getCar().getCompany(),
                purchase.getCar().getModel(),
                purchase.getCar().getModelYear(),
                purchase.getCar().getPrice(),
                purchase.getLocation().getCountry(),
                purchase.getLocation().getCity(),
                purchase.getPurchaseDate()
        );
    }
}
