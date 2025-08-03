import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class DriverFactory {

    static void setUp() throws MalformedURLException {
        String browser = System.getProperty("browser", "chrome");

        switch(browser.toLowerCase()) {
            case "chrome":
                Configuration.browser = "chrome";
                break;
            case "firefox":
                Configuration.browser = "firefox";
                break;
            case "remote":
                ChromeOptions options = new ChromeOptions();
                options.setCapability("selenoid:options", new HashMap<String, Object>() {{
                    /* How to add test badge */
                    put("name", "Test badge...");

                    /* How to set session timeout */
                    put("sessionTimeout", "15m");

                    /* How to set timezone */
                    put("env", new ArrayList<String>() {{
                        add("TZ=UTC");
                    }});

                    /* How to add "trash" button */
                    put("labels", new HashMap<String, Object>() {{
                        put("manual", "true");
                    }});

                    /* How to enable video recording */
                    put("enableVideo", true);
                }});
                RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);

            default: throw new IllegalArgumentException("Unknown browser name -> " + browser);
        }

        ChromeOptions options = new ChromeOptions();
        options.setCapability("selenoid:options", new HashMap<String, Object>() {{
            /* How to add test badge */
            put("name", "Test badge...");

            /* How to set session timeout */
            put("sessionTimeout", "15m");

            /* How to set timezone */
            put("env", new ArrayList<String>() {{
                add("TZ=UTC");
            }});

            /* How to add "trash" button */
            put("labels", new HashMap<String, Object>() {{
                put("manual", "true");
            }});

            /* How to enable video recording */
            put("enableVideo", true);
        }});
        RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
    }
}
