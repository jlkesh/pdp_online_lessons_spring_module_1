package uz.pdp.springframeworkcore;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.Arrays;

public class Main {
    static ExpressionParser parser = new SpelExpressionParser();
    public static void main(String[] args) {

        Expression expression = parser.parseExpression("('Hello ' + 'PDP!').toLowerCase");
        String value = expression.getValue(String.class);
        System.out.println(value);
        System.out.println("('Hello ' + 'PDP!').toUpperCase");

        int[] inlineArray = ge("{1,2,3,4,4,5}").getValue(int[].class);
        System.out.println(inlineArray[2]);
        System.out.println(Arrays.toString(inlineArray));
        int[][] inlineMatrix = ge("{{3,2},{4,5},{9,12}}").getValue(int[][].class);
        System.out.println(Arrays.deepToString(inlineMatrix));
        System.out.println(inlineMatrix[0][1]);
        System.out.println(ge("'Hello PDP!'.length").getValue(Integer.class));
        System.out.println(ge("'Hello PDP!'.substring(3, 9)").getValue(String.class));
        System.out.println(ge("'Hello PDP!'.toUpperCase").getValue(String.class));
        System.out.println(ge("'Hello PDP!\t'.repeat(10)").getValue(String.class));
        Club club = new Club();
        EvaluationContext context = new StandardEvaluationContext(club);
        System.out.println(ge("isMember('john')").getValue(context, Boolean.class));
        Emp emp = ge("new uz.pdp.springframeworkcore.Emp('Elmurodov Javohir', 28)").getValue(Emp.class);
        System.out.println(emp);
        System.out.println(ge("5 != 5").getValue());
        System.out.println(ge("5 == 5").getValue());
        System.out.println(ge("5 >= 5").getValue());
        System.out.println(ge("5 > 5").getValue());
        System.out.println(ge("5 < 5").getValue());
        System.out.println(ge("5 > 4").getValue());
        System.out.println(":::::::::::::::::::: Instance Of ::::::::::::::::::::");
        System.out.println(ge("123 instanceof T(Integer)").getValue());
        System.out.println(ge("123 instanceof T(Float)").getValue());
        System.out.println(ge("'123' instanceof T(String)").getValue());
        System.out.println(ge("123.09F instanceof T(Float)").getValue());
        System.out.println(ge("123.09 instanceof T(Double)").getValue());
        System.out.println(":::::::::::::::::::: regex ::::::::::::::::::::");
        System.out.println(ge("'998908115224' matches '^9989\\d{8}$'").getValue());
        System.out.println(":::::::::::::::::::: logical operators ::::::::::::::::::::");
        System.out.println(ge("true and false").getValue());
        System.out.println(ge("true or false").getValue());
        System.out.println(ge("true and true").getValue()); // and  => &&, or => ||
        System.out.println(ge("12 > 3 and 3 > 1").getValue()); // and  => &&, or => ||
        System.out.println(ge("isMember('Jlkesh') and isMember('john')").getValue(context)); // and  => &&, or => ||
        System.out.println(ge("isMember('Jlkesh') and !isMember('john')").getValue(context)); // and  => &&, or => ||
    }

    private static Expression ge(String expressionString) {
        return parser.parseExpression(expressionString);
    }
}