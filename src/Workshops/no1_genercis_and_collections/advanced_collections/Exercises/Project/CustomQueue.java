package Workshops.no1_genercis_and_collections.advanced_collections.Exercises.Project;

import java.util.*;

public class CustomQueue<T> {

    private final Deque<T> queue;
    private final Deque<T> queueVip;
    private final Map<String, Integer> counterMap = new HashMap<>();

    public CustomQueue(Deque<T> queue, Deque<T> queueVip) {
        this.queue = queue;
        this.queueVip = queueVip;
    }

    public void welcome(T item) {
        boolean isAdded = queue.offer(item);
        System.out.printf("%s, came to the queue: %s%n", item, isAdded);
        printTotalQueue();
        System.out.println();
    }

    public void welcomeVip(T item) {
        boolean isAdded = queueVip.offer(item);
        queueVip.offer(item);
        System.out.printf("%s, came to the queue: %s%n", item, isAdded);
        printTotalQueue();
    }
    public void printTotalQueue() {
        ArrayList<T> totalLIst = new ArrayList<>(queueVip);
        totalLIst.addAll(queue);
        System.out.println(totalLIst);
        System.out.println();
    }

    public Integer getAndIncreaseCounter(String key) {
        Integer tempCounter = counterMap.getOrDefault(key, 0);
        counterMap.put(key, ++tempCounter);
        return tempCounter;
    }


    public void enter() {
        if (queueVip.isEmpty()) {
            System.out.println("No items in the VIP queue");
        } else {
            T poll = queueVip.poll();
            System.out.printf("Processing queue: %s arrived at the store %n", poll);
            printTotalQueue();
            System.out.println();
            return;

        }
        if (queue.isEmpty()) {
            System.out.println("No items in the queue");
            return;
        } else {
            T poll = queue.poll();
            System.out.printf("Processing queue: %s arrived at the store %n", poll);
            printTotalQueue();
            System.out.println();
        }
    }

    public void leave(T item) {
        if (queueVip.contains(item)) {
            System.out.printf("Leaving vip queue: %s%n ", item);
            queueVip.remove(item);
            printTotalQueue();
            System.out.println();
        }
        if (queue.contains(item)) {
            System.out.printf("Leaving queue: %s%n ", item);
            queue.remove(item);
            printTotalQueue();
            System.out.println();
        } else {
            System.out.println(item + "is not in the queue");
        }

    }
}
