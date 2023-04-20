package Patterns.Behavioral.Strategy;

public class CourierStrategy implements  DeliveryStrategy{
    @Override
    public void deliver(Parcel parcel) {
        System.out.printf("Parcel %s delivered by Courier %n", parcel.getName());
    }
}
