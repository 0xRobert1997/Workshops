package Patterns.Behavioral.Observer;

public class Main {
    public static void main(String[] args) {

        NewsTopic subject = new NewsTopic();

        Observer observer1 = new NewSubscriber("username1");
        Observer observer2 = new NewSubscriber("username2");
        Observer observer3 = new NewSubscriber("username3");

        subject.reigster(observer1);
        subject.reigster(observer2);
        subject.reigster(observer3);

        subject.setNews("Some new news!");

        // java8
        Observer observer4 = news -> System.out.printf("%s - message %n", news);
        System.out.println();
        subject.reigster(observer4);
        subject.setNews("Something new");
    }
}
