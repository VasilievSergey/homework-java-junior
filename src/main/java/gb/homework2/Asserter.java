package gb.homework2;

public class Asserter {

    public static void assertEquals(int expected, int actual) {
        if (expected != actual) {
            throw new AssertionError("Expected: " + expected + ", but received: " + actual);
        }
    }

}

class TestAsserter {

    public static void main(String[] args) {
        try {
            test();
        } catch (AssertionError e) {
            System.out.println("Test Failed: " + e.getMessage());
        }
    }

    public static void test() {
        Asserter.assertEquals(5, 5);
        Asserter.assertEquals(10, 15);
    }

}