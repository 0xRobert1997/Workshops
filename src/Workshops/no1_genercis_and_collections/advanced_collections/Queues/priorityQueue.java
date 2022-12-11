package Workshops.no1_genercis_and_collections.advanced_collections.Queues;

import Workshops.no1_genercis_and_collections.advanced_collections.Maps.treeMap;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class priorityQueue {

    public static void main(String[] args) {
        List<Integer> input = List.of(1, 5, 9, 1, 5, 28, 1, 62, 2);

        Queue<Integer> priority = new PriorityQueue<>();

        for (Integer i : input) {
            priority.offer(i);
            System.out.println(priority);
        }
        // jak dodajemy elementy do prority to nie do końca trzyma kolejności
        // ale jak ściągamy to już usuwa w kolejności

        int size = priority.size();
        for (int i = 0; i < size; i++) {
            System.out.println("priority.peek: " + priority.peek());
            System.out.println(priority);
            System.out.println("prority.pool: " + priority.poll());
            System.out.println(priority);
        }

    }
}
