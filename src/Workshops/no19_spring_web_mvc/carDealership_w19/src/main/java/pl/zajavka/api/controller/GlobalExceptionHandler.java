package pl.zajavka.api.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import pl.zajavka.domain.exception.ProcessingException;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(Exception ex) {
        String msg = String.format("Other exception occurred: [%s]", ex.getMessage());
        log.error(msg, ex);
        ModelAndView modelView = new ModelAndView("error");
        modelView.addObject("errorMessage", msg);
        return modelView;
    }
    @ExceptionHandler(ProcessingException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ModelAndView handleException(ProcessingException ex) {
        String msg = String.format("Processing exception occurred: [%s]", ex.getMessage());
        log.error(msg, ex);
        ModelAndView modelView = new ModelAndView("error");
        modelView.addObject("errorMessage", msg);
        return modelView;
    }
}
