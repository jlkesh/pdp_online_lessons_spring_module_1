package uz.pdp.springframeworkcore;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class Club {

    public String field = null;//"Default Field";
    public List<String> members = List.of("Javohir", "Akbar", "Jlkesh");
    public Map<String, String> progs = Map.of(
            "key1", "Java",
            "key2", "Scala",
            "key3", "Groovy",
            "key4", "Python"
    );

    public boolean isMember(String name) {
        return members.contains(name);
    }
}
