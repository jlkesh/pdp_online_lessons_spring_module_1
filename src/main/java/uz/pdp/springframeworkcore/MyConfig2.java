package uz.pdp.springframeworkcore;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig2 {

    @Bean
    public MyBean2 myBean2(MyBean myBean) {
        return new MyBean2(myBean);
    }
}
