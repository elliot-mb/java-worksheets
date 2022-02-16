import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class QuestionRunner {
    public static void main(String[] args){
        System.out.println(EqualsGeneric.isEqual(1, 1)); //return true
        System.out.println(EqualsGeneric.isEqual("1", 1)); //return false
        System.out.println(EqualsGeneric.isEqual("Hello", "Hello")); //return true
        System.out.println(EqualsGeneric.isEqual("Hello", "Hi")); //return false

        System.out.println(EqualsGeneric.reverse(new ArrayList<Integer>(Arrays.asList(1,2,3,4))));
        System.out.println(EqualsGeneric.reverse(new ArrayList<String>(Arrays.asList("a","b","c","d"))));
    }
}
