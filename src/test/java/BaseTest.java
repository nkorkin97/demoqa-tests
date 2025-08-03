import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

@Tag("Now")
public class BaseTest extends DriverFactory {

    @Test
    public void testDriverFactory() {
        open("https://google.com");
        $("textarea[title='Поиск']").setValue("Selenide").pressEnter();
        sleep(10000);
    }
}
