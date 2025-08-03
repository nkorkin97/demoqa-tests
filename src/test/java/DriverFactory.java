import com.codeborne.selenide.Configuration;

public class DriverFactory {

    static void setUp() {
        String browser = System.getProperty("browser", "chrome");

        switch(browser.toLowerCase()) {
            case "chrome":
                Configuration.browser = "chrome";
                break;
            case "firefox":
                Configuration.browser = "firefox";
            default: throw new IllegalArgumentException("Unknown browser name -> " + browser);
        }
        Configuration.remote = "http://localhost:4444/wd/hub";
    }
}
