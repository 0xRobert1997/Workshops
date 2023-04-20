package Workshops.no2_functional_programming.Exercises.ex2;

public class main {

    public static void main(String[] args) {

        exerciseInterface<Car> Imp1 = (s, i, c) -> s.length() + i + c.toString().length();
        exerciseInterface<Car> Imp2 = (s, i, c) -> {
            int countLetter = countSign(s, 'a');
            int countComma = countSign(c.toString(), ',');
            int countEquals = countSign(c.toString(), '=');
            return countLetter + countComma + countEquals + i;
        };



        System.out.println(Imp1.myMethod("Czerwony", 2, new Car("x1")));
        System.out.println(Imp2.myMethod("Zielony", 4, new Car("x,=,x")));


    }

    private static int countSign(String str, char letter) {
        int counter = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == letter){
                counter++;
            }
        }
        return counter;
    }

    static class Car {
        private final String model;

        public Car(String model) {
            this.model = model;
        }

        @Override
        public String toString() {
            return  model;
        }
    }
}
