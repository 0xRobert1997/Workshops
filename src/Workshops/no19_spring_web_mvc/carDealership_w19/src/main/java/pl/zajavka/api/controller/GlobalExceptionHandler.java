package pl.zajavka.api.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ModelAndView handleException(Exception ex) {
        String msg = String.format("Other expcetion occured: [%s]", ex.getMessage());
        log.error(msg, ex);
        ModelAndView modelView = new ModelAndView("error");
        modelView.addObject("errorMessage", msg);
        return modelView;
    }
}
