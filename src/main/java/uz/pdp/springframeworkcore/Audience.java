package uz.pdp.springframeworkcore;

import org.aspectj.lang.annotation.*;

@Aspect
public class Audience {

    @Before("execution(* uz.pdp.springframeworkcore.Performance.perform(..))")
    public void silencingPhones() {
        System.out.println("Silencing Cell Phones");
    }

    @Before("execution(* uz.pdp.springframeworkcore.Performance.perform(..))")
    public void takeSeats() {
        System.out.println("Take seats");
    }

    @AfterReturning("execution(* uz.pdp.springframeworkcore.Performance.perform(..))")
    public void applause() {
        System.out.println("\uD83D\uDC4F \uD83D\uDC4F\uD83D\uDC4F\uD83D\uDC4F\uD83D\uDC4F");
    }

    @After("execution(* uz.pdp.springframeworkcore.Performance.perform(..))")
    public void leave() {
        System.out.println("Leave Concert Hall");
    }
    @AfterThrowing("execution(* uz.pdp.springframeworkcore.Performance.perform(..))")
    public void refund() {
        System.out.println("Refund...... 👿👿👿👿👿👿👿👿👿👿👿👿👿👿👿👿👿👿");
    }

}
