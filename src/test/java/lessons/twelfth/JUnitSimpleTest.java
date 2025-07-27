package lessons.twelfth;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import lessons.twelfth.data.Locale;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class JUnitSimpleTest {


    @BeforeEach
    void setUp() {
        System.out.println("Предусловия для каждого теста - это @BeforeEach ");
        open("https://ya.ru");
    }

    @Disabled("Тикет в Jira") // Исключение теста из test run, можно воткнуть перед классом, задизейблив все тесты класса
    @Test //Используется либо @Test, либо @ParameterizedTest
    void disabledTest() {
        System.out.println("Run disabledTest...");
        Assertions.assertTrue(1 == 1);
    }

    @DisplayName("Демонстрационный тест") // Интегрирована с аллюром, имя теста
    @Test //Используется либо @Test, либо @ParameterizedTest
    @Tags({@Tag("BLOCKER"), @Tag("UI_TEST")}) // Можно запускать тесты с определенными тегами
    void simpleTest() {
        System.out.println("Run simpleTest... ");
        Assertions.assertTrue(3 > 2);
    }


    @ParameterizedTest //Используется либо @Test, либо @ParameterizedTest
    @CsvSource({
            "Allure testops, qameta.io",
            "Selenide, ru.selenide.org"
    })
    void searchTest(
            String productName,
            String productUrl
    ) {
        ($("#text")).setValue(productName).pressEnter();
        ($(".content")).shouldHave(Condition.text(productUrl));
    }

    @ParameterizedTest
    @ValueSource(
            strings = {"Allure testops", "Selenide"}
    )
    void searchSnippets(String productName) {
        $("#text").setValue(productName).pressEnter();
        $$(".serp-item").shouldHave(CollectionCondition.sizeGreaterThan(10));
    }

}
