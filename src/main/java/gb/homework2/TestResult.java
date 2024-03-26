package gb.homework2;

import java.util.List;

public class TestResult {
    private final int totalTests;
    private final int passedTests;
    private final List<String> failedTests;

    public TestResult(int totalTests, int passedTests, List<String> failedTests) {
        this.totalTests = totalTests;
        this.passedTests = passedTests;
        this.failedTests = failedTests;
    }

    public int getTotalTests() {
        return totalTests;
    }

    public int getPassedTests() {
        return passedTests;
    }

    public List<String> getFailedTests() {
        return failedTests;
    }
}
