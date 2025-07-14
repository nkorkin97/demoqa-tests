import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.open;

public class FirstJUnitTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("это метод @BeforeAll");
    }
    @BeforeEach
    void beforeEach() {
        System.out.println("это метод @BeforeEach");
    }

    @AfterEach
    void afterEach() {
        System.out.println("это метод @AfterEach");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("это метод @AfterAll");
    }

    @Test
    public void firstTest() {
        System.out.println("это первый тест");
        Assertions.assertTrue(true);
    }

    @Test
    void secondeTest() {
        System.out.println("Это второй тест");
    }

}
