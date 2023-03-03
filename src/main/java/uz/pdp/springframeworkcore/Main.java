package uz.pdp.springframeworkcore;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.EventListenerMethodProcessor;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import uz.pdp.springframeworkcore.beans.Emp;
import uz.pdp.springframeworkcore.beans.Employee;
import uz.pdp.springframeworkcore.beans.Person;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello PDP!");
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ioc-config.xml");
//        System.out.println(":::::::::::::::::::::::::: Main console ::::::::::::::::::::::::::");
        /*Person person = context.getBean(Person.class);
        System.out.println(person);
        Person person2 = context.getBean(Person.class);
        System.out.println(person2);
        person2.setAge("29");
        person2.setFullName("NurIslom Hasanov");
        System.out.println("person = " + person);
        System.out.println("person2 = " + person2);*/
        Resource resource = new ClassPathResource("ioc-config.xml");
        BeanFactory context = new XmlBeanFactory(resource);
        System.out.println("Main main console message");
        System.out.println(System.identityHashCode(context.getBean(Person.class)));
      /*  for (int i = 0; i < 100; i++) {
            System.out.println(System.identityHashCode(context.getBean(Emp.class)));
        }*/
        /*Emp employee = context.getBean(Emp.class);
        System.out.println(System.identityHashCode(employee));*/
        /*Emp employee2 = context.getBean(Emp.class);
        System.out.println(System.identityHashCode(employee2));
        Emp employee3 = context.getBean(Emp.class);
        System.out.println(System.identityHashCode(employee3));*/
        /*context.close();*/
    }
}