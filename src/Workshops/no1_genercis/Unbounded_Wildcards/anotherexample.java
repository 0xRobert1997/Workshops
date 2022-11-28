package Workshops.no1_genercis.Unbounded_Wildcards;

public class anotherexample {

    public static void main(String[] args) {
        Tuna<String> tuna = new Tuna<>();
        tuna.eat("trash");

        // przy wildcardach nie można później wywoływać czegoś co doda elementy
        // Tuna<?> newTuna = tuna;
        // newTuna.eat("some other trash");
    }


    static class Tuna<U> {
        private U element;

        void eat(U element) {
            this.element = element;
        }
    }
}
