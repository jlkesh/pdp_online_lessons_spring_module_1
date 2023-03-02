package uz.pdp.springframeworkcore;

import org.springframework.context.annotation.*;

@Configuration
@Import({MyConfig.class, MyConfig2.class})
@ImportResource("classpath:ioc-settings.xml")
@PropertySource("classpath:application.properties")
public class MainApplicationConfigurations {


    @Bean(initMethod = "initSomeData")
    @Conditional(DbInitCondition.class)
    public DbInit dbInit() {
        return new DbInit();
    }

}
