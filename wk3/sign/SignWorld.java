public class SignWorld {

    public static void main(String[] args) {
        Sign pos = Sign.POSITIVE;
        Sign neg = Sign.NEGATIVE;
        System.out.println(pos.toString() + " flipped is " + pos.flip().toString());
        System.out.println(neg.toString() + " flipped is " + neg.flip().toString());
    }
}
