public class Tuple<T1, T2> extends Id{
    private final T2 b;

    <T1, T2> Tuple(T1 a, T2 b){
        super(a);
        this.b = b;
    }

}
