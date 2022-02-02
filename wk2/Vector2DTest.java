class Vector2DTest {
    public static void main(String[] args) {
        Vector2D a = new Vector2D(10.0, 10.0);
        System.out.println(a.toString()); // "Vector2D(10.00, 10.00)"
        System.out.println(a.add(a).toString()); // "Vector2D(20.00, 20.00)"
        System.out.println(a.toString()); // "Vector2D(10.00, 10.00)"
    }
}