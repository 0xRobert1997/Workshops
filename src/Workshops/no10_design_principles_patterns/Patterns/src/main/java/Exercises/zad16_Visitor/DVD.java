package Exercises.zad16_Visitor;

public class DVD implements Element{

    double price;
    String title;
    String author;

    public DVD(double price, String title, String author) {
        this.price = price;
        this.title = title;
        this.author = author;
    }

    @Override
    public void accept(Visitor visitor) {
        double result = this.price * visitor.getDvdDiscount();
        System.out.println("Discounted dvd price:" + result );
    }
}
