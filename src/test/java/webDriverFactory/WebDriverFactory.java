package webDriverFactory;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class WebDriverFactory {
    public static WebDriver createDriver(String value) throws MalformedURLException {
//        if (driver1.equals("chrome"))
//        {
//            return new ChromeDriver();
//        }
//        else if (driver1.equals("selenoid"))
//        {
//            ChromeOptions options = new ChromeOptions();
//            options.setCapability("browserVersion", "128.0");
//            options.setCapability("selenoid:options", new HashMap<String, Object>() {{
//                put("name", "Test badge...");
//                put("sessionTimeout", "15m");
//                put("env", new ArrayList<String>() {{
//                    add("TZ=UTC");
//                }});
//                put("labels", new HashMap<String, Object>() {{
//                    put("manual", "true");
//                }});
//                put("enableVideo", true);
//            }});
//
//            RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
//            return driver;
//        }
//        return null;

        switch(value) {
            case "chrome": return new ChromeDriver();
            case "selenoid":
                ChromeOptions options = new ChromeOptions();
                options.setCapability("browserVersion", "128.0");
                options.setCapability("selenoid:options", new HashMap<String, Object>() {{
                put("name", "Test badge...");
                put("sessionTimeout", "15m");
                put("env", new ArrayList<String>() {{
                    add("TZ=UTC");
                }});
                put("labels", new HashMap<String, Object>() {{
                    put("manual", "true");
                }});
                put("enableVideo", true);
                }});

                RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
                return driver;
        }
        return null;
    }
}
