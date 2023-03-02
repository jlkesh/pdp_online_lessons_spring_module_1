package uz.pdp.springframeworkcore;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import uz.pdp.springframeworkcore.config.MyConfig;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext container = new AnnotationConfigApplicationContext(MyConfig.class);
        MyBean2 myBean2 = container.getBean(MyBean2.class);
        myBean2.hi();
    }
}