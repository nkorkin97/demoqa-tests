package lessons.fourteenth.tests;

import com.github.javafaker.Faker;
import lessons.fourteenth.pages.RegistarationPage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.File;


public class PracticeFormWithJavaFakerTest extends BaseTest {

    RegistarationPage registarationPage = new RegistarationPage();

    Faker faker = new Faker();

    String
            userName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender = "Other",
            phone = "1234567890",
            month = "August",
            year = "1997",
            day = "22",
            subject = "English",
            hobbieSports = "Sports",
            hobbieReading = "Reading",
            hobbieMusic = "Music",
            address = faker.address().fullAddress(),
            state = "NCR",
            city = "Delhi";

    File fileExample = new File("src/test/resources/example/test.jpg");

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
                .setHobbies(hobbieSports)
                .setHobbies(hobbieReading)
                .setHobbies(hobbieMusic)
                .setPicture(fileExample)
                .setCurrentAddress(address)
                .setState(state)
                .setCity(city)
                .clickSubmit()
                .checkModal()
                .checkResultModalValue("Student Name", userName + " " + lastName);

        System.out.println("");
    }

}
