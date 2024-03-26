package gb.homework2;

import java.lang.reflect.AccessFlag;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestRunner {
    public static TestResult run(Class<?> testClass) {
        List<String> failedTests = new ArrayList<>();
        int totalTests = 0;
        int passedTests = 0;
        final Object testObj = initTestObj(testClass);
        for (Method testMethod : testClass.getDeclaredMethods()) {
            if (testMethod.accessFlags().contains(AccessFlag.PRIVATE)) {
                continue;
            }

            if (testMethod.getAnnotation(Test.class) != null) {
                totalTests++;
                try {
                    testMethod.invoke(testObj);
                    passedTests++;
                } catch (IllegalAccessException | InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return new TestResult(totalTests, passedTests, failedTests);
    }

    private static Object initTestObj(Class<?> testClass) {
        try {
            Constructor<?> noArgsConstructor = testClass.getConstructor();
            return noArgsConstructor.newInstance();
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("Нет конструктора по умолчанию");
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException("Не удалось создать объект тест класса");
        }
    }

}