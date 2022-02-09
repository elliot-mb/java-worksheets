public class TestUtils {
    static void assertEquals(String s1, String s2, String s3) throws AssertionError {
        if (!(s1.equals(s2))) throw new AssertionError(s3);

    }

    static void assertEquals(int i, int j, String s) {
        if(i != j) throw new AssertionError(s);
    }

    static void assertUniversalEquals(int i, int j, String e) { assertEquals(i, j, e); }
    static void assertUniversalEquals(int i, String s, String e) { throw new AssertionError(e); }

    static void assertUniversalEquals(String s, int i, String e) {
        throw new AssertionError(e);
    }

    static void assertUniversalEquals(String s1, String s2, String e) {
        assertEquals(s1, s2, e);
    }

    public static void main(String[] args) {
        String str1 = "hello";
        String str2 = "hello";
        String str3 = "Hello";
        String str4 = "mind";
        assertEquals(str1, str2, "error: expecting " + str1 + " but was " + str2);
        assertEquals(str2, str3, "error: expecting " + str2 + " but was " + str3);
        assertEquals(str1, str4, "error: expecting " + str1 + " but was " + str4);

        assertUniversalEquals(1, 2, "Err!"); // Err!: expecting 1(class java.lang.Integer) but got 2(class java.lang.Integer)
        assertUniversalEquals("1", "2", "Err!"); // Err!: expecting 1(class java.lang.String) but got 2(class java.lang.String)
        assertUniversalEquals("1", null, "Err!"); // Err!: expecting 1(class java.lang.String) but got null
        assertUniversalEquals(1, "1", "Err!"); // Err!: expecting 1(class java.lang.Integer) but got 1(class java.lang.String)
        assertUniversalEquals(null, null, "Err!"); // OK

        assertEquals(1, 2, "done goofed");
    }
}