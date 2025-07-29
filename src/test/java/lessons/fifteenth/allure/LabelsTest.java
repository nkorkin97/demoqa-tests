package lessons.fifteenth.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.step;

public class LabelsTest {

    private static final String REPOSITORY = "eroshenkoam/allure-example";

    @Test
    @Feature("Issue в репозитории")
    @Story("Создание Issue")
    @Owner("nkorkin")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "GitHub", url = "https://testng.github.com")
    @DisplayName("Отображаемое имя")
    public void testStaticLabels() {

    }

    @Test
    public void testDynamicsLabels() {
    }

    // 01:27:00

}
