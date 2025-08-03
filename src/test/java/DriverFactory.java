import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;

public class DriverFactory {

    static void setUp() {
        String browser = System.getProperty("browser", "chrome");

        switch(browser.toLowerCase()) {
            case "chrome":
                Configuration.browser = "chrome";
                break;
            case "firefox":
                Configuration.browser = "firefox";
                break;
            default: throw new IllegalArgumentException("Unknown browser name -> " + browser);
        }
        Configuration.remote = "http://localhost:4444/wd/hub";
        HashMap<String, Object> selenoidOptions = new HashMap<>();
        selenoidOptions.put("enableVNC", true);
        selenoidOptions.put("enableVideo", false);

        Configuration.browserCapabilities.setCapability("selenoid:options", selenoidOptions);
    }
}
