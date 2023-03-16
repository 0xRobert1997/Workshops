package Behavioral.ChainOfResponsibility.genericImp;

public class TextOpinionHandler extends GenericHandler<String> {
    @Override
    protected String handleInput(String input) {
        return input.replace("mam złą opinię o zajavce", "zajavka jest super");
    }
}
