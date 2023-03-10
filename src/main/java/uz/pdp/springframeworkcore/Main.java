package uz.pdp.springframeworkcore;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import uz.pdp.springframeworkcore.user.User;
import uz.pdp.springframeworkcore.user.UserDao;
import uz.pdp.springframeworkcore.user.UserDao2;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ioc_settings.xml");
        /*UserDao userDao = context.getBean(UserDao.class);
        User user = User.builder()
                .username("NurIslom")
                .password("123")
                .age(19)
                .build();*/
        /*System.out.println("userDao.findById(1) = " + userDao.findById(1));*/
        /*userDao.save(user);*/
        /*userDao.findAll(18, 40).forEach(System.out::println);*/
        /*System.out.println("userDao.save2(user) = " + userDao.save2(user));*/
        UserDao userDao = context.getBean(UserDao.class);
        User user = User.builder()
                .username("admin")
                .password("123")
                .age(28)
                .build();
        userDao.save(user);
        /*System.out.println("userDao2.save2(user) = " + userDao2.save2(user));*/
    }
}