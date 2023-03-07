package uz.pdp.springframeworkcore;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@ToString
public class ArithmeticOperators {
    @Value("#{123 + 4}")
    public int add;

    @Value("#{12 ^ 2}")
    public int power;

    @Value("#{12 mod 5}")
    public int mod;

    @Value("#{(2 + 3)*2 + 7}")
    public int brakets;

    @Value("#{ 4 ge 4}")
    public boolean l;

    @Value("#{ club.field != null ?club.field:'Default'}")
    public String ternary;
    @Value("#{ club.members[2]}")
    public String nthMember;

    @Value("#{ club.progs['key4']}")
    public String value;




}
