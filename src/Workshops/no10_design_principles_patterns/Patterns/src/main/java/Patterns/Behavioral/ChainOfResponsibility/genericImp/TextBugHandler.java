package Patterns.Behavioral.ChainOfResponsibility.genericImp;

public class TextBugHandler extends GenericHandler<String> {
    @Override
    protected String handleInput(String input) {
        return input.replace("w zadaniu jest błąd", "w zadaniu nie ma błędu");
    }
}
