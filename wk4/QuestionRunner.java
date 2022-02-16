public class QuestionRunner {
    public static void main(String[] args){
        System.out.println(EqualsGeneric.isEqual(1, 1)); //return true
        System.out.println(EqualsGeneric.isEqual("1", 1)); //return false
        System.out.println(EqualsGeneric.isEqual("Hello", "Hello")); //return true
        System.out.println(EqualsGeneric.isEqual("Hello", "Hi")); //return false
    }
}
