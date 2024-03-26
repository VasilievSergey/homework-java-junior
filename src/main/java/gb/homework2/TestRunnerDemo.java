package gb.homework2;

public class TestRunnerDemo {

    public static void main(String[] args) {
        TestResult result = TestRunner.run(TestAsserter.class);
        System.out.println("Total tests: " + result.getTotalTests());
        System.out.println("Passed tests: " + result.getPassedTests());
        System.out.println("Failed tests: ");
        for (String failedTest : result.getFailedTests()) {
            System.out.println(failedTest);
        }
    }
}