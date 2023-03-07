package uz.pdp.springframeworkcore;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@ToString
@Component
@PropertySource("classpath:application.properties")
public class BaseDAO {
    @Value("${database:postgres}")
    private String database;
    @Value("${max.connection.limit:10}")
    private int maximumCollectionLimit; //${max.connection.limit}
}
