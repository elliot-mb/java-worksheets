public class EqualsGeneric {
    static <T> boolean isEqual(T left, T right){
        return left.equals(right);
    }
}
