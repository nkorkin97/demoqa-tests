package lessons.twelfth;

import java.util.List;
import java.util.stream.Stream;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import lessons.twelfth.data.Locale;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;


public class EnumSimpleTest {

    static Stream<Arguments> enumSearchTest1() {
        return Stream.of(
                Arguments.of(Locale.EN, List.of("Quick start","Docs","FAQ","Blog","Javadoc","Users","Quotes")),
                Arguments.of(Locale.RU, List.of("С чего начать?","Док","ЧАВО","Блог","Javadoc","Пользователи","Отзывы"))
        );
    }

    @MethodSource("enumSearchTest1") // Если стрим не называется как тест, следует указать название метода-стрима
    @ParameterizedTest(name = "Для локали {0} отображаются кнопки {1}")
    @Tag("BLOCKER")
    void enumSearchTest(
            Locale locale,
            List<String> buttons
    ) {
        Configuration.pageLoadStrategy = "eager";
        open("https://selenide.org");
        $$("#languages a").find(Condition.text(locale.name())).click();
        $$(".main-menu-pages a").
                filter(Condition.visible)
                .shouldHave(CollectionCondition.texts(buttons));
    }
}
