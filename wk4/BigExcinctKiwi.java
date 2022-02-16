public class BigExcinctKiwi implements Bird {
    private final Dodo d = new Dodo();
    private final Kiwi k = new Kiwi();

    public void fly(){
        d.fly();
        k.fly();
    }
}
