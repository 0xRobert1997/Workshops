package Behavioral.ChainOfResponsibility.genericImp;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Main {
    public static void main(String[] args) {
/*        GenericHandler<String> textBugHandler = new TextBugHandler();
        GenericHandler<String> textOpinionHandler = new TextOpinionHandler();
        textBugHandler.setNextHandler(textOpinionHandler);

        String result = textBugHandler.handle("Wziąłem udział w zajavce i powiem wam, że zajavka nie jest super. " +
                "Zrobiłem zadanie i w zadaniu jest błąd. " +
                "Podsumowując, mam złą opinię o zajavce!");

        System.out.println(result);*/


        UnaryOperator<String> textZajavkaHandler = (String input) ->
                input.replace("zajavka nie jest super", "zajavka jest super");
        UnaryOperator<String> textBugHandler = (String input) ->
                input.replace("w zadaniu jest błąd", "w zadaniu nie ma błędu");
        UnaryOperator<String> textOpinionHandler = (String input) ->
                input.replace("mam złą opinię o zajavce", "zajavka jest super");

        Function<String, String> pipeline = textZajavkaHandler
                .andThen(textZajavkaHandler)
                .andThen(textBugHandler)
                .andThen(textOpinionHandler);

        String input = "Wziąłem udział w zajavce i powiem wam, że zajavka nie jest super. " +
                "Zrobiłem zadanie i w zadaniu jest błąd. " +
                "Podsumowując, mam złą opinię o zajavce!";

        System.out.println(pipeline.apply(input));


    }
}
