package Workshops.no3_localization_and_files.Exercises.project.domain;

import Workshops.no3_localization_and_files.Exercises.project.domain.Car;
import Workshops.no3_localization_and_files.Exercises.project.domain.Location;
import Workshops.no3_localization_and_files.Exercises.project.domain.Person;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Purchase {

    private long id;
    private Person person;
    private Car car;
    private Location location;
    private LocalDate purchaseDate;

    public Purchase(long id, Person person, Car car, Location location, LocalDate purchaseDate) {
        this.id = id;
        this.person = person;
        this.car = car;
        this.location = location;
        this.purchaseDate = purchaseDate;
    }

    public long getId() {
        return id;
    }

    public Person getPerson() {
        return person;
    }

    public Car getCar() {
        return car;
    }

    public Location getLocation() {
        return location;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "id=" + id +
                ", person=" + person +
                ", car=" + car +
                ", location=" + location +
                ", purchaseDate=" + purchaseDate +
                '}';
    }
}
