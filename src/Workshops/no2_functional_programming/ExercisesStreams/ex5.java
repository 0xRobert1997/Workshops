package Workshops.no2_functional_programming.ExercisesStreams;

public class ex5 {

    public static void main(String[] args) {

        String isPalindrome = "kajak";

        String reversed = isPalindrome.chars()
                .mapToObj(i -> String.valueOf((char) i))
                // b.concat(a) zeby skleić w odwróconej kolejności
                .reduce("", (a, b) -> b.concat(a));

        System.out.println(isPalindrome.equals(reversed));
    }
}
