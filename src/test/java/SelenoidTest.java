import com.codeborne.selenide.Configuration;
import lessons.tenth.pages.RegistarationPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

@Tag("nkorkin")
public class SelenoidTest {

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
        Configuration.remote = "http://localhost:8080/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserVersion", "127.0");
        capabilities.setCapability("selenoid:options", new HashMap<String, Object>() {{
            put("name", "Test badge...");
            put("sessionTimeout", "15m");
            put("enableVNC", true);
            put("env", new ArrayList<String>() {{
                add("TZ=UTC");
            }});
            put("labels", new HashMap<String, Object>() {{
                put("manual", "true");
            }});
            put("enableVideo", true);
        }});
        Configuration.browserCapabilities = capabilities;
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
                .setState("NCR") //55
                .setCity("Delhi")
                .clickSubmit()
                .checkModal()
                .checkResultModalValue("Student Name", userName + " " + lastName);
    }

}
