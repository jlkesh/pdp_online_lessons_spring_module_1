package uz.pdp.springframeworkcore;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ioc-config.xml");
        Performance performance = context.getBean(Performance.class);
        performance.perform();
    }
}