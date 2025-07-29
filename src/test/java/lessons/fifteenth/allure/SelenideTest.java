package lessons.fifteenth.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideTest {

    @Test
    public void testIssueSearch() {
        Configuration.browserSize = "1920x1080";
        open("https://github.com/");
        SelenideLogger.addListener("allure", new AllureSelenide());

        $(".search-input").scrollTo().click();
        $("#query-builder-test").scrollTo().setValue("eroshenkoam/allure-example");
        $("#query-builder-test").scrollTo().submit();
        $("[data-testid = 'results-list'] [href='/eroshenkoam/allure-example']").scrollTo().click();
        $("#pull-requests-tab").scrollTo().click();
        $(".js-navigation-container").$("#issue_79").shouldBe(Condition.exist);
    }
}
