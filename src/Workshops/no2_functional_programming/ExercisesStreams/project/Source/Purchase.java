package Workshops.no2_functional_programming.ExercisesStreams.project.Source;

import Workshops.no2_functional_programming.ExercisesStreams.project.Source.Client;
import Workshops.no2_functional_programming.ExercisesStreams.project.Source.Product;

import java.time.LocalDate;

public class Purchase {
    private final Client buyer;
    private final Product product;
    private final long quantity;
    private final Delivery delivery;
    private final Payment payment;
    private final LocalDate when;
    private Status status = Status.PAID;
    // konstruktory, gettery itp


    public Purchase(Client buyer, Product product, long quantity, Delivery delivery, Payment payment, LocalDate when) {
        this.buyer = buyer;
        this.product = product;
        this.quantity = quantity;
        this.delivery = delivery;
        this.payment = payment;
        this.when = when;
    }

    public Client getBuyer() {
        return buyer;
    }

    public Product getProduct() {
        return product;
    }

    public long getQuantity() {
        return quantity;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public Payment getPayment() {
        return payment;
    }

    public LocalDate getWhen() {
        return when;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Purchase purchase)) return false;

        return getBuyer() != null ? getBuyer().equals(purchase.getBuyer()) : purchase.getBuyer() == null;
    }

    @Override
    public int hashCode() {
        return getBuyer() != null ? getBuyer().hashCode() : 0;
    }

    public enum Delivery {
        IN_POST,
        UPS,
        DHL
    }
    public enum Payment {
        CASH,
        BLIK,
        CREDIT_CARD
    }
    public enum Status {
        PAID,
        SENT,
        DONE
    }
}
