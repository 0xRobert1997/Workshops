package code.domain;

import lombok.Builder;
import lombok.Value;
import lombok.With;

import java.util.Objects;

@With
@Builder
public final class CarServiceRequest {
    private final Customer customer;
    private final Car car;
    private final String customerComment;

    public Customer getCustomer() {
        return this.customer;
    }

    public Car getCar() {
        return this.car;
    }

    public String getCustomerComment() {
        return this.customerComment;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof CarServiceRequest)) return false;
        final CarServiceRequest other = (CarServiceRequest) o;
        final Object this$customer = this.getCustomer();
        final Object other$customer = other.getCustomer();
        if (this$customer == null ? other$customer != null : !this$customer.equals(other$customer)) return false;
        final Object this$car = this.getCar();
        final Object other$car = other.getCar();
        if (this$car == null ? other$car != null : !this$car.equals(other$car)) return false;
        final Object this$customerComment = this.getCustomerComment();
        final Object other$customerComment = other.getCustomerComment();
        if (this$customerComment == null ? other$customerComment != null : !this$customerComment.equals(other$customerComment))
            return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $customer = this.getCustomer();
        result = result * PRIME + ($customer == null ? 43 : $customer.hashCode());
        final Object $car = this.getCar();
        result = result * PRIME + ($car == null ? 43 : $car.hashCode());
        final Object $customerComment = this.getCustomerComment();
        result = result * PRIME + ($customerComment == null ? 43 : $customerComment.hashCode());
        return result;
    }

    public String toString() {
        return "CarServiceRequest(customer=" + this.getCustomer() + ", car=" + this.getCar() + ", customerComment=" + this.getCustomerComment() + ")";
    }

    @With
    @Value
    @Builder
    public static class Customer {
        String name;
        String surname;
        String phone;
        String email;
        Address address;

    }

    @With
    @Value
    @Builder
    public static class Address {

        String country;
        String city;
        String postalCode;
        String address;
    }

    @With
    @Value
    @Builder
    public static class Car {
        String vin;
        String brand;
        String model;
        Integer year;

        public Boolean shouldExistInCarToBuy() {
            return Objects.isNull(brand)
                    && Objects.isNull(model)
                    && Objects.isNull(year);
        }
    }
}
