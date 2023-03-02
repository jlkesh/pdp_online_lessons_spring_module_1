package uz.pdp.springframeworkcore;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext container = new AnnotationConfigApplicationContext(MyConfig.class);
        /*container.register(MyConfig.class);*/
        /*container.refresh();*/
        MyBean2 myBean2 = container.getBean(MyBean2.class);
        myBean2.hi();
    }
}