package lessons.linux;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import webDriverFactory.WebDriverFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class Sample {

    @Test
    public void sample() throws MalformedURLException {
        WebDriver driver = WebDriverFactory.createDriver("selenoid");
        driver.get("https://google.com");
    }
}
