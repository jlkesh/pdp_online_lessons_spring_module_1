package uz.pdp.springframeworkcore.beans;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@ToString
@Getter
@Setter
@Component
public class Emp {
    private String fullName;
    private String age;

    public Emp() {
    }

    @PostConstruct
    public void init(){
        System.out.println("init method");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("destroy method");
    }
}
