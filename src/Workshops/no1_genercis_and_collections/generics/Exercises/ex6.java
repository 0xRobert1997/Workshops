package Workshops.no1_genercis_and_collections.generics.Exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ex6 {

    public static void main(String[] args) {

        Stack<ItemOnTable> stack = new Stack<>();

        stack.put(new Book());
        stack.put(new Smartphone());
        stack.put(new Newspaper());
        stack.put(new Newspaper());
        System.out.println(stack);
        System.out.println(stack.take());
        System.out.println(stack);

    }

    static class Stack <T extends ItemOnTable> {

        private List<T> stack = new ArrayList<>();

        public void put(T element) {
            if (element == null) {
                return;
            }
            stack.add(element);
        }

        public Optional<T> take() {
            if (stack.size() == 0) {
                return Optional.empty();
            }
            return Optional.ofNullable(stack.remove(stack.size() - 1));
            // size - 1 bo to stos i mozemy zabrac tylko element z wierzchu
        }

        @Override
        public String toString() {
            return stack.toString();
        }
    }



    interface ItemOnTable { }
    static class Book implements ItemOnTable{ }
    static class Smartphone implements ItemOnTable{ }
    static class Newspaper implements ItemOnTable{ }
}
