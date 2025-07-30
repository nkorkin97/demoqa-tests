package lessons.tenth.tests;

import com.codeborne.selenide.Configuration;
import lessons.tenth.pages.RegistarationPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.File;

@Tag("checkIt")
public class PracticeFormWithPageObjectsTest {

    RegistarationPage registarationPage = new RegistarationPage();

    String
            userName = "Nikita",
            lastName = "Korkin",
            email = "nikita@korkin.com",
            gender = "Other",
            phone = "1234567890",
            month = "August",
            year = "1997",
            day = "22",
            subject = "English",
            hobbie1 = "Sports";

    File fileExample = new File("src/test/resources/example/test.jpg");

    @BeforeAll
    static void beforeAll() {
        Configuration.headless = true;
        Configuration.baseUrl = "https://demoqa.com/";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.browser = "chrome";
    }

    @Test
    void practiceFormTest() {
        registarationPage.openPage()
                .setFirstName(userName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setPhone(phone)
                .setDateOfBirth(month, year, day)
                .setSubject(subject)
                .setHobbies(hobbie1)
                .setHobbies("Reading")
                .setHobbies("Music")
                .setPicture(fileExample)
                .setCurrentAddress("Example")
                .setState("NCR")
                .setCity("Delhi")
                .clickSubmit()
                .checkModal()
                .checkResultModalValue("Student Name", userName + " " + lastName);
    }

}
