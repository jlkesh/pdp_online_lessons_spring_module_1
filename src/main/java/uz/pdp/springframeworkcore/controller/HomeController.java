package uz.pdp.springframeworkcore.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Locale;
import java.util.Objects;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final MessageSource messageSource;



    @GetMapping("/home")
    public String homePage(@CookieValue String language, @RequestParam String lang) {
        lang = Objects.requireNonNullElse(lang, language);
        String message = messageSource.getMessage("welcome3", new Object[]{"Javohir"}, Locale.forLanguageTag(lang));
        System.out.println("message = " + message);
        return "home";
    }
}
