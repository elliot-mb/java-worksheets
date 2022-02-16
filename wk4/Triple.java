public class Triple<T1, T2, T3> extends Tuple{
    public final T3 c;

    Triple(T1 a, T2 b, T3 c){
        super(a, b);
        this.c = c;
    }
}
