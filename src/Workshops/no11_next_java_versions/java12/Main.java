package Workshops.no11_next_java_versions.java12;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    // Collector teeing
    // String indent i transform

    public static void main(String[] args) {

        Pair collect = Stream.of(5, 1, 32, 12)
                .collect(Collectors.teeing(
                        Collectors.counting(),
                        Collectors.summingInt(e -> e),
                        (collector1, collector2) -> new Pair(collector1, collector2)
                ));
        System.out.println(collect);


        String input = "###\n\tzajavka\n\t\tzajavka\n\t\tzajavka\n###";

        // wcięcia zostają bez zmian
        System.out.println("#1\n" + input.indent(0));
        // przy wartości <0 wcięcią zostają zmniejszone o wartość znaku
        System.out.println("#2\n" + input.indent(-1));
        // dodaje na początku każdej linijki specje * podana wartość
        System.out.println("#3\n" + input.indent(1));


        String input2 = "Hej zajavkowicze! Co tam słychać?";

        Integer transform = input2.transform(e -> e.length());
        String[] s = input2.transform(e -> e.split(" "));


    }

    static class Pair {
        Long count;
        Integer sum;
        public Pair(Long count, Integer sum) {
            this.count = count;
            this.sum = sum;
        }

        public Long getCount() {
            return count;
        }

        public Integer getSum() {
            return sum;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "count=" + count +
                    ", sum=" + sum +
                    '}';
        }
    }
}
