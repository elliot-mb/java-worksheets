import java.util.List;
import java.util.ArrayList;

public class EqualsGeneric {
    static <T> boolean isEqual(T left, T right){
        return left.equals(right);
    }

    static List<T> reverse(List<T> list) {
        List<T> reversedList = new ArrayList<T>();

        int n = list.size();

        int i = n;

        while (i > -1) {
            reversedList.add(list.get(i));
        }

        return reversedList;
    }
}
