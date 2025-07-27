package lessons.tenth.pages.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import lessons.tenth.pages.RegistarationPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class RegistartionResultsModal {

    private ElementsCollection row = $$("tbody tr");

    public void verifyModalAppears() {
        $(".modal-content").should(Condition.appear);
        $("#example-modal-sizes-title-lg").shouldHave(Condition.text("Thanks for submitting the form"));
    }

    public RegistartionResultsModal checkResult(String key, String value) {
        row.findBy(Condition.text(key)).shouldHave(Condition.text(value));
        return this;
    }

}
