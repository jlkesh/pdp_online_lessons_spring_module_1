package uz.pdp.springframeworkcore;

import java.util.Random;

public class Performance {
    public void perform() {
        if (new Random().nextBoolean()) {
            System.out.println("Performing Well");
        } else {
            throw new RuntimeException("Performed bad");
        }
    }

}
