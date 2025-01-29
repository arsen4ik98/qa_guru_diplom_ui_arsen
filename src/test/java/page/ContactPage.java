package page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ContactPage {

    private SelenideElement contact = $(".mx-3");

    @Step("Ищем контактный телефон")
    public ContactPage searchPhone() {
        contact.shouldHave(text("тел: +7 (495) 980-61-81"));
        return this;
    }
}
