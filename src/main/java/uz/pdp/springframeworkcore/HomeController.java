package uz.pdp.springframeworkcore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class HomeController {
    private final Service service;

    @Autowired // @Inject
    public HomeController(@Qualifier("userService2") Service service) { // @Named
        this.service = service;
    }

    @Override
    public String toString() {
        return "HomeController{" +
                "service=" + service +
                '}';
    }
}
