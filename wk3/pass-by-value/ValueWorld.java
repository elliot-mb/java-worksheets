public class ValueWorld { //question 1.4
    public static void main(String[] args) {
        StringBox box = new StringBox("a");
        box.append0("a");
        box.append1("a");
        box.concat(box);
        System.out.println(box.get());
    }
}
