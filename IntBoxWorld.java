public class IntBoxWorld{

    public static void main(String[] args){
        IntBox a = new IntBox(10).add(10);
        System.out.println(a); // "IntBox(20)"
        System.out.println(a.multiply(10)); // "IntBox(200)"
        System.out.println(a); // "IntBox(200)"
    }

}