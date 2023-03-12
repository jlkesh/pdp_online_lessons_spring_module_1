package uz.pdp.springframeworkcore.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import uz.pdp.springframeworkcore.config.SessionUser;

import java.util.Locale;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final MessageSource messageSource;

    private final SessionUser sessionUser;


    @GetMapping("/home")
    public String homePage() {
        Locale locale = sessionUser.getLocale();
        String message = messageSource.getMessage("welcome3", new Object[]{"Javohir"}, locale);
        System.out.println("message = " + message);
        return "home";
    }
}
