import java.util.ArrayList;
import java.util.Arrays;
import java.util.IdentityHashMap;

public class QuestionRunner {
    public static void main(String[] args){
        System.out.println(EqualsGeneric.isEqual(1, 1)); //return true
        System.out.println(EqualsGeneric.isEqual("1", 1)); //return false
        System.out.println(EqualsGeneric.isEqual("Hello", "Hello")); //return true
        System.out.println(EqualsGeneric.isEqual("Hello", "Hi")); //return false

        System.out.println(EqualsGeneric.reverse(new ArrayList<Integer>(Arrays.asList(1,2,3,4))));
        System.out.println(EqualsGeneric.reverse(new ArrayList<String>(Arrays.asList("a","b","c","d"))));

        //Question 4
        Unit u1 = Unit.getUnit();
        Unit u2 = Unit.getUnit();

        System.out.println(u1==u2);

        //Question 5
        IdentityFormatter id = new IdentityFormatter();
        UppercaseFormatter upper = new UppercaseFormatter();
        ROT13Formatter rot13 = new ROT13Formatter();

        String test1 = "Hello world!";
        System.out.println(id.format(test1)); //Hello world!
        System.out.println(upper.format(test1)); // HELLO WORLD!
        System.out.println(rot13.format(test1)); //Uryyb jbeyq!

        BigExcinctKiwi bek = new BigExcinctKiwi();
        bek.fly();
    }
}
