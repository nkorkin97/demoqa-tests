package lessons.fifteenth.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.commands.TakeScreenshot;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.attachment;

public class WebSteps {

    @Step("Открываем главную страницу")
    public void openMainPage() {
        open("https://github.com/");
    }

    @Step("Ищем репозиторий")
    public void searchForRepo(String repository) {
        $(".search-input").scrollTo().click();
        $("#query-builder-test").scrollTo().setValue(repository);
        $("#query-builder-test").scrollTo().submit();
    }

    @Step("Кликаем по ссылке на репозиторий")
    public void clickOnRepo() {
        $("[data-testid = 'results-list'] [href='/eroshenkoam/allure-example']").scrollTo().click();
    }

    @Step("Открываем вкладку пулл реквестов")
    public void openPullRequestTab() {
        $("#pull-requests-tab").scrollTo().click();
    }

    @Step("Проверяем issue")
    public void shoulSeeRequestWithNumber() {
        $(".js-navigation-container").$("#issue_79!").shouldBe(Condition.exist);
    }

    @Attachment(value = "Screenshot", type = "image")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
