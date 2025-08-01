package lessons.tenth.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lessons.tenth.pages.components.CalendarComponent;
import lessons.tenth.pages.components.RegistartionResultsModal;
import org.junit.jupiter.api.Assertions;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class RegistarationPage {

    private final String TITLE_TEXT = "Student Registration Form";

    private CalendarComponent calendarComponent = new CalendarComponent();
    private RegistartionResultsModal registartionResultsModal = new RegistartionResultsModal();

    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderInput = $("#genterWrapper"),
            phoneInput = $("#userNumber"),
            subjectsInput = $("#subjectsInput"),
            subjectOptions = $(".subjects-auto-complete__option"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            pictureUploader = $("#uploadPicture"),
            currentAddress = $("#currentAddress"),
            state = $("#state"),
            city = $("#city"),
            stateCityWrapper = $("#stateCity-wrapper"),
            submit = $("#submit");


    public RegistarationPage openPage() {
        open("automation-practice-form");
        $(".practice-form-wrapper").shouldHave(Condition.text(TITLE_TEXT));
        return this;
    }

    public RegistarationPage setFirstName(String value) {
        firstNameInput.shouldBe(Condition.visible, Condition.enabled).scrollTo().setValue(value);
        return this;
    }

    public RegistarationPage setLastName(String value) {
        lastNameInput.shouldBe(Condition.visible, Condition.enabled).scrollTo().setValue(value);
        return this;
    }

    public RegistarationPage setEmail(String value) {
        emailInput.shouldBe(Condition.visible, Condition.enabled).scrollTo().setValue(value);
        return this;
    }

    public RegistarationPage setGender(String value) {
        genderInput.$(byText(value)).shouldBe(Condition.visible, Condition.enabled).scrollTo().click();
        return this;
    }

    public RegistarationPage setPhone(String value) {
        phoneInput.shouldBe(Condition.visible, Condition.enabled).scrollTo().setValue(value);
        return this;
    }

    public RegistarationPage setDateOfBirth(String monthValue, String yearValue, String dayValue) {
        calendarComponent.setDate(monthValue, yearValue, dayValue);
        return this;
    }

    public RegistarationPage setSubject(String value) {
        subjectsInput.shouldBe(Condition.visible, Condition.enabled).scrollTo().setValue(value);
        subjectOptions.shouldHave(Condition.text(value)).shouldBe(Condition.visible, Condition.enabled).scrollTo().click();
        return this;
    }

    public RegistarationPage setHobbies(String value) {
        hobbiesWrapper.$(byText(value)).shouldBe(Condition.visible, Condition.enabled).scrollTo().click();
        return this;
    }

    public RegistarationPage setPicture(File file) {
        pictureUploader.uploadFile(file);
        String filePath = pictureUploader.getValue();
        System.out.println(file.getName());
        Assertions.assertTrue(filePath.contains(file.getName()));
        return this;
    }

    public RegistarationPage setCurrentAddress(String value) {
        currentAddress.shouldBe(Condition.visible, Condition.enabled).scrollTo().setValue(value);
        return this;
    }

    public RegistarationPage setState(String value) {
        state.shouldBe(Condition.visible, Condition.enabled).scrollTo().click();
        stateCityWrapper.$(byText(value)).shouldBe(Condition.visible, Condition.enabled).scrollTo().click();
        return this;
    }

    public RegistarationPage setCity(String value) {
        city.shouldBe(Condition.visible, Condition.enabled).scrollTo().click();
        stateCityWrapper.$(byText(value)).shouldBe(Condition.visible, Condition.enabled).scrollTo().click();
        return this;
    }

    public RegistarationPage clickSubmit() {
        submit.shouldBe(Condition.visible, Condition.enabled).scrollTo().click();
        return this;
    }

    public RegistarationPage checkModal() {
        registartionResultsModal.verifyModalAppears();
        return this;
    }

    public RegistarationPage checkResultModalValue(String key, String value) {
        registartionResultsModal.checkResult(key, value);
        return this;
    }

}
