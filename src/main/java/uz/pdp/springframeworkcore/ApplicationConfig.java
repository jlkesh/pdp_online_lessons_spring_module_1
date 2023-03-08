package uz.pdp.springframeworkcore;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class ApplicationConfig {

    @Bean
    public Performance performance() {
        return new Performance();
    }

    @Bean
    public Audience audience() {
        return new Audience();
    }

}
