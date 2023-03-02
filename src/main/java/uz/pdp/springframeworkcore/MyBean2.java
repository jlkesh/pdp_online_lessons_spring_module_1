package uz.pdp.springframeworkcore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyBean2 {

    private final MyBean myBean;

    public MyBean2(MyBean myBean) {
        this.myBean = myBean;
    }

    public void hi() {
        System.out.println("MyBean2");
        myBean.hi();
    }

}
