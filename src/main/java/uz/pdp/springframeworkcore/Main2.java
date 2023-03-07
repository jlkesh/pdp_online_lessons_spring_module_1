package uz.pdp.springframeworkcore;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main2 {
    public static void main(String[] args) {
       AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("uz.pdp.springframeworkcore");
        BaseDAO baseDAO = context.getBean(BaseDAO.class);
        System.out.println(baseDAO);
        /*ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ioc-config.xml");
        Person bean = context.getBean(Person.class);
        System.out.println("bean = " + bean)*/
    }
}
