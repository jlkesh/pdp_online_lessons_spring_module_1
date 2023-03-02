package uz.pdp.springframeworkcore;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class MyBean {

    public void hi() {
        System.out.println("Hello PDP !");
        System.out.println("Learn Java Stack Here");
    }

    @PostConstruct
    public void init() {
        System.out.println(getClass().getName() + " init method");
    }

    @PreDestroy
    public void destroy() {
        System.out.println(getClass().getName() + " destroy method");
    }

}
