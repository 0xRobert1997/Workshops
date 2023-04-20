package Exercises.zad16_Visitor;

public class DiscountVisitor implements Visitor {
        private final double bookDiscount = 0.9;
        private final double dvdDiscount = 0.8;

    public double getBookDiscount() {
        return bookDiscount;
    }

    public double getDvdDiscount() {
        return dvdDiscount;
    }


}
