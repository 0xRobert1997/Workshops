package Exercises.zad16_Visitor;

public class Book implements Element{
    double price;
    String title;
    String author;

    public Book(double price, String title, String author) {
        this.price = price;
        this.title = title;
        this.author = author;
    }

    @Override
    public void accept(Visitor visitor) {
        double result = this.price * visitor.getBookDiscount();
        System.out.println("Discounted book price:" + result);
    }
}
