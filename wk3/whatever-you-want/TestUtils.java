public class TestUtils {
    static void assertEquals(String s1, String s2, String s3) {}

    static void assertEquals(int i, int j, String s) {
        try{
            if(i != j) { throw new AssertionError(); }
        }catch (AssertionError ae){
            ae.printStackTrace();
        }
    }

    public void assertUniversalEquals() {}

    public static void main(String[] args){
        assertEquals(1, 2, "fail (epic)");
    }
}