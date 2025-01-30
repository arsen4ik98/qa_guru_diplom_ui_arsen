package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class VacancyPage {

    @Step("Ищем контактный телефон")
    public VacancyPage vacancyPageText() {
        $(".view-header").shouldHave(text("Вакансии"));
        return this;
    }

    @Step("Проверяем checkbox \"Горячие вакансии\"")
    public VacancyPage checkboxGoryachee() {
        $("[name='field_goryachee_value']").shouldBe(Condition.checked);
        return this;
    }

    @Step("Проверяем checkbox \"Горячие вакансии\"")
    public VacancyPage checkboxUdalenno() {
        $("[name='field_udalennka_value']").shouldBe(Condition.checked);
        return this;
    }

}
