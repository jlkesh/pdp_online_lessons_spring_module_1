package uz.pdp.springframeworkcore;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

    @Bean
    public MyBean myBean() {
        return new MyBean();
    }

    @Bean
    public MyBean2 myBean2(MyBean myBean){
        return new MyBean2(myBean);
    }
}
