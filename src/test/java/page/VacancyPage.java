package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class VacancyPage {

    private final SelenideElement specialization = $("#edit-field-specializaciya-target-id--2"),
            location = $("#edit-field-lokaciya-target-id--2"),
            searchButton = $("#views-exposed-form-vakansii-block-1").$("button");
    private final ElementsCollection specializationElements = $("#edit-field-specializaciya-target-id--2").$$("option"),
            locationElements = $("#edit-field-lokaciya-target-id--2").$$("option");


    public void openPage() {
        open("/information/vacancies/");
    }

    @Step("Ищем название страницы")
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

    @Step("Нажать на \"Поиск\"")
    public VacancyPage clickSearch() {
        searchButton.click();
        return this;
    }

    @Step("Нажать на \"Специализация\"")
    public VacancyPage clickToSpecializationBtn() {
        specialization.click();
        return this;
    }

    @Step("Выбрать из выпадающего списка \"Специализация\"")
    public VacancyPage chooseSpecializationOption(String name) {
        specializationElements.findBy(text(name)).click();
        return this;
    }

    @Step("Нажать на \"Локация\"")
    public VacancyPage clickToLocationBtn() {
        location.click();
        return this;
    }

    @Step("Выбрать из выпадающего списка \"Локация\"")
    public VacancyPage chooseLocationOption(String name) {
        locationElements.findBy(text(name)).click();
        return this;
    }

}
