package lessons.fourteenth.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lessons.fourteenth.pages.components.CalendarComponent;
import lessons.fourteenth.pages.components.RegistartionResultsModal;
import org.junit.jupiter.api.Assertions;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

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
        firstNameInput.setValue(value);
        return this;
    }

    public RegistarationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistarationPage setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public RegistarationPage setGender(String value) {
        genderInput.$(byText(value)).click();
        return this;
    }

    public RegistarationPage setPhone(String value) {
        phoneInput.setValue(value);
        return this;
    }

    public RegistarationPage setDateOfBirth(String monthValue, String yearValue, String dayValue) {
        calendarComponent.setDate(monthValue, yearValue, dayValue);
        return this;
    }

    public RegistarationPage setSubject(String value) {
        subjectsInput.setValue(value);
        subjectOptions.shouldHave(Condition.text(value)).click();
        return this;
    }

    public RegistarationPage setHobbies(String value) {
        hobbiesWrapper.$(byText(value)).click();
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
        currentAddress.setValue(value);
        return this;
    }

    public RegistarationPage setState(String value) {
        state.click();
        stateCityWrapper.$(byText(value)).click();
        return this;
    }

    public RegistarationPage setCity(String value) {
        city.click();
        stateCityWrapper.$(byText(value)).click();
        return this;
    }

    public RegistarationPage clickSubmit() {
        submit.scrollTo().click();
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
