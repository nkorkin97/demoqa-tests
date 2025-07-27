package lessons.eight;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTest {
    String BASE_URL = "https://demoqa.com/automation-practice-form";

    SelenideElement firstName = $x("//input[@id='firstName']");
    SelenideElement lastName = $x("//input[@id='lastName']");
    SelenideElement email = $x("//input[@id='userEmail']");

    SelenideElement maleRadion =  $$(".custom-radio").get(0);
    SelenideElement femaleRadion = $x("(//div[contains (@class, 'custom-radio')])[2]");
    SelenideElement otherRadion = $x("(//div[contains (@class, 'custom-radio')])[3]");

    SelenideElement mobile = $x("//input[@id='userNumber']");

    SelenideElement datePicker = $x("//div[@class='react-datepicker']");
    SelenideElement dateOfBirth = $x("//input[@id='dateOfBirthInput']");

    SelenideElement monthSelect = $x("//select[@class='react-datepicker__month-select']");
    ElementsCollection monthOptions = $$x("//select[@class='react-datepicker__month-select']//option");

    SelenideElement yearSelect = $x("//select[@class='react-datepicker__year-select']");
    ElementsCollection yearOptions = $$x("//select[@class='react-datepicker__year-select']//option");

    ElementsCollection dayOptions = $$x("//div[contains (@class, 'react-datepicker__day')]");

    SelenideElement subjects = $x("//div[contains (@class, 'subjects-auto-complete__value-container')]");
    SelenideElement subjectInput = $x("//div[@class='subjects-auto-complete__input']//input");
    ElementsCollection subjectsMenu = $$x("//div[contains (@class, 'subjects-auto-complete__menu')]");

    SelenideElement hobbiesSports = $x("(//div[contains (@class, 'custom-checkbox')])[1]");
    SelenideElement hobbiesReading = $x("(//div[contains (@class, 'custom-checkbox')])[2]");
    SelenideElement hobbiesMusic = $x("(//div[contains (@class, 'custom-checkbox')])[3]");

    SelenideElement pictureUploader = $x("//input[@id='uploadPicture']");

    SelenideElement state = $("#state");
    ElementsCollection stateCollection = $$x("//div[@class=' css-26l3qy-menu']//div//div");

    SelenideElement city = $("#city");

    SelenideElement table = $x("//table[contains (@class, table)]");

    @Test
    void practiceFormTest() {

        Configuration.pageLoadStrategy = "eager";
        Configuration.browser = "chrome";
        open(BASE_URL);

        firstName.setValue("Nikita");
        lastName.setValue("Korkin");
        email.setValue("nikKorkin@text.ru");
        maleRadion.click();
        mobile.setValue("89996663221");

        dateOfBirth.click();
        datePicker.isDisplayed();

        monthSelect.click();
        SelenideElement month = monthOptions.find(Condition.text("January"));
        month.click();

        yearSelect.click();
        SelenideElement year = yearOptions.find(Condition.text("2024"));
        year.click();

        SelenideElement day = dayOptions.find(Condition.text("24"));
        day.click();
        datePicker.shouldNotBe(Condition.visible);

        subjects.click();
        subjectInput.setValue("english");
        SelenideElement subjectElement = subjectsMenu.find(Condition.text("English"));
        subjectElement.shouldHave(Condition.text("English")).click();

        hobbiesSports.click();
        hobbiesMusic.click();
        hobbiesReading.click();

        File testFile = new File("src/test/resources/test.jpg");
        pictureUploader.uploadFile(testFile); //
        String filePath = pictureUploader.getValue();
        Assertions.assertTrue(filePath.contains("example/test.jpg"));

        state.scrollTo().click();
        $(".css-26l3qy-menu")
                .$("div")
                .$("div").shouldHave(Condition.text("NCR"))
                        .click();

        city.scrollTo().click();
        $(".css-26l3qy-menu")
                .$("div")
                .$("div")
                .shouldHave(Condition.text("Delhi"))
                .click();

        SelenideElement submitBtn = $("#submit");
        submitBtn.scrollTo().click();

        SelenideElement table = $(".table-responsive");
        table.shouldBe(Condition.visible);
        table.$("tbody").$$("tr").get(0).shouldHave(Condition.text("Nikita Korkin"));
    }

}
