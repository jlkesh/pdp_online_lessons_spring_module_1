package uz.pdp.springframeworkcore.config;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.LocaleResolver;

import java.util.Locale;

@Component
public class SessionUser {
    private final HttpServletRequest request;
    private final LocaleResolver localeResolver;

    public SessionUser(HttpServletRequest request, LocaleResolver localeResolver) {
        this.request = request;
        this.localeResolver = localeResolver;
    }

    public Locale getLocale() {
        return localeResolver.resolveLocale(request);
    }
}
