package lessons.fifteenth.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.step;

public class StepsTest {

    private static final String REPOSITORY = "eroshenkoam/allure-example";

    @Test
    public void testLambdaStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.browserSize = "1920x1080";

        step("Открываем глвную страницу", () -> {
            open("https://github.com/");
        });
        step("Ищем репозиторий " + REPOSITORY, () -> {
            $(".search-input").scrollTo().click();
            $("#query-builder-test").scrollTo().setValue(REPOSITORY);
            $("#query-builder-test").scrollTo().submit();
        });
        step("Кликаем по ссылке репозитория " + REPOSITORY, () -> {
            $("[data-testid = 'results-list'] [href='/eroshenkoam/allure-example']").scrollTo().click();
        });
        step("Открываем таб pull requests", () -> {
            $("#pull-requests-tab").scrollTo().click();
        });
        step("Проверяем pull request c номером", () -> {
            $(".js-navigation-container").$("#issue_79").shouldBe(Condition.exist);
        });
    }

    @Test
    public void testAnnotatedSteps() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.searchForRepo(REPOSITORY);
        steps.clickOnRepo();
        steps.openPullRequestTab();
        steps.shoulSeeRequestWithNumber();
    }
}
