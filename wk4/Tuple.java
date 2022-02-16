public class Tuple<T1, T2> extends Id<T1>{
    private final T2 b;

    Tuple(T1 a, T2 b){
        super(a);
        this.b = b;
    }

}
