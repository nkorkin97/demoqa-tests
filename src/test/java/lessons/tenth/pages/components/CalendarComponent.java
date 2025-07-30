package lessons.tenth.pages.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CalendarComponent {

    private SelenideElement
            datePickerInput = $("#dateOfBirthInput"),
            monthSelect = $(".react-datepicker__month-select"),
            yearSelect = $(".react-datepicker__year-select");


    public void setDate(String monthValue, String yearValue, String dayValue) {
        datePickerInput.click();
        $(".react-datepicker").isDisplayed();
        monthSelect.selectOption(monthValue);
        yearSelect.selectOption(yearValue);
        $(".react-datepicker__day--0" + dayValue).click();
        $(".react-datepicker").shouldNotBe(Condition.visible);
    }

}
