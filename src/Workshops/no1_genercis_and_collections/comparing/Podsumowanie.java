package Workshops.no1_genercis_and_collections.comparing;

import java.util.*;

public class Podsumowanie {

    public static void main(String[] args) {
        Comparator<String> comparator = Comparator.naturalOrder();
        List<Book> bookList = Arrays.asList(new Book(22, "raz"), new Book(80, "raz"), new Book(810, "dwa"));

        // użycie comparator'a
        // nie trzeba tutaj użyć getterów bo klasa jest static nested, gdyby była w innym pliku to trzeba by było użyć getterów

        //bookList.sort((b1, b2) -> b1.numberOfPages - b2.numberOfPages);

        // warto wyłączać sobie komparator na fragmenty, jeśli jest problem z chainowaniem
        // najpierw po tytule, a potem po ilości stron
        Comparator<Book> comparingByTitle = Comparator.comparing(book -> book.getTitle());
        Comparator<Book> comparingByPages = Comparator.comparing(book -> book.getNumberOfPages());

       bookList.sort(comparingByTitle.thenComparing(comparingByPages));
        // albo
       bookList.sort(comparingByTitle.thenComparingInt(book -> book.getNumberOfPages()));


        Collections.sort(bookList);



        // użycie comparable
        // żeby tego użyć, klasa musi implementować comparable z generykiem typu tej klasa

       // Collections.sort(bookList);
    }

    private static class Book implements Comparable<Book> {
        private int numberOfPages;
        private String title;

        public Book(int numberOfPages, String title) {
            this.numberOfPages = numberOfPages;
            this.title = title;
        }

        public int getNumberOfPages() {
            return numberOfPages;
        }

        public String getTitle() {
            return title;
        }

        @Override
        public int compareTo(Book o) {
            return this.numberOfPages - o.numberOfPages;
        }
    }


}
