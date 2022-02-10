public class StringBox {

    private String s;

    StringBox(String _s){
        s = _s;
    }

    public String get(){
        return s;
    }

    public static void append0(String a){
        String ab = a + "b";
    }
    // not possible to get a return value from a stateless void method

    public static String append1(final String a){
        return a + "b";
    }

    public static void concat(StringBox a){
        a.s = a.s + "b";
    }
    // method may be void but the object is stateful and is passed by reference-value
    // so it's state changes and can be retrieved after
}
