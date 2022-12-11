package Workshops.no1_genercis_and_collections.advanced_collections.Queues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Queue;

public class queueAndDeque {

    public static void main(String[] args) {
        List<Integer> input = List.of(1, 5, 9, 1, 62);

        Queue<Integer> queue = new ArrayDeque<>();
        /*  offer() - dodawanie e
            peek() - zwraca pierwszy element kolejki
            poll() - zwraca i usuwa pierwszy element albo null jeśli queue jest pusta
            removes() - -,,- ale nie zwraca nulla
         */

        Deque<Integer> stack = new ArrayDeque<>(input);
        /*  push() - dodaje e z porzodu
            peek() - tak samo zwraca pierwszy element
            pop() -  zwraca usuwa pierwszy elemen
         */


        for (Integer element : input) {
            queue.offer(element);
         //   System.out.println("queue.offer " + queue.offer(element) + ", added element: " + element);
         //   System.out.println(queue);
        }

        int size = queue.size();
        for (int i = 0; i < size; i++) {
            System.out.println("queue.peek: " + queue.peek());
            System.out.println(queue);
            System.out.println("queue.poll: " + queue.poll());
            System.out.println(queue);
        }

        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack);
    }
}
