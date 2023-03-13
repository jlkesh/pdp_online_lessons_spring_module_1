package uz.pdp.springframeworkcore.handlers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import uz.pdp.springframeworkcore.exceptions.NotFoundException;

@ControllerAdvice("uz.pdp.springframeworkcore")
public class GlobalExceptionHandler {

    @ExceptionHandler({NotFoundException.class})
    public ModelAndView error_404(HttpServletRequest request, NotFoundException e) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error/404");
        modelAndView.addObject("message", e.getMessage());
        modelAndView.addObject("path", request.getRequestURI());
        modelAndView.addObject("back_path", e.getPath());
        return modelAndView;
    }


}
