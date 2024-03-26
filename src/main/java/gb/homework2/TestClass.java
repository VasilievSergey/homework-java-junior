package gb.homework2;


import org.junit.jupiter.api.*;

public class TestClass {

    // Методы, выполняющиеся перед началом всех тестов
    @BeforeAll
    static void beforeAllTests() {
        System.out.println("Before all tests method");
    }

    // Методы, выполняющиеся перед каждым тестом
    @BeforeEach
    void beforeEachTest() {
        System.out.println("Before each test method");
    }

    @Test(order = 3)
    void test1() {
        System.out.println("Test 1");
    }

    @Test(order = 2)
    void test2() {
        System.out.println("Test 2");
    }
    @Test(order = 1)
    void test3() {
        System.out.println("Test 3");
    }

    @org.junit.jupiter.api.Test
    void test4() {
        System.out.println("Test 4");
    }

    // Методы, выполняющиеся после каждого теста
    @AfterEach
    void afterEachTest() {
        System.out.println("After each test method");
    }

    // Методы, выполняющиеся после завершения всех тестов
    @AfterAll
    static void afterAllTests() {
        System.out.println("After all tests method");
    }
}