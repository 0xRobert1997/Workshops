package Behavioral.Strategy;

import java.util.Collections;

public class Main {

    public static void main(String[] args) {

        OnlineStore onlineStore = new OnlineStore();

//        onlineStore.addParcel(new Parcel("skarpety"));
//        onlineStore.addParcel(new Parcel("mleko"));
//        onlineStore.addParcel(new Parcel("monitor"));
//
//        System.out.println("##Courier");
//        onlineStore.deliver(new CourierStrategy());
//
//        System.out.println("##Locker");
//        onlineStore.deliver(new ParcelLockerStrategy());
//
//        System.out.println("##Post");
//        onlineStore.deliver(new PostStrategy());

        onlineStore.deliver(parcel -> System.out.printf("Parcel %s delivered by Courier %n", parcel.getName()));
        onlineStore.deliver(parcel -> System.out.printf("Parcel %s delivered by ParcelLocker %n", parcel.getName()));
        onlineStore.deliver(parcel -> System.out.printf("Parcel %s delivered by Post %n", parcel.getName()));
    }
}
