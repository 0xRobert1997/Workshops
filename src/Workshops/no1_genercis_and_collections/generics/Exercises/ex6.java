package Workshops.no1_genercis.Exercises;

public class ex6 {

    public static void main(String[] args) {

        StackOfItems myStack = new StackOfItems(new Smartphone(), new Book(), new Newspaper());
    }


    static class StackOfItems <T, U, V > {
        final T one;
        final U two;
        final V three;

        public StackOfItems(T one, U two, V three) {
            this.one = one;
            this.two = two;
            this.three = three;
        }
    }


    static class Smartphone {

    }

    static class Book {

    }

    static class Newspaper {

    }
}
