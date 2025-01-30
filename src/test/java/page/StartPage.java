package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class StartPage {

    private ElementsCollection vacancy = $$(".container-fluid a");
    private SelenideElement  headerMenu = $(".text-end.d-flex.align-items-center a img"),
            filtervacancy = $(".nav-item-vac"),
    exposed_form = $(".views-exposed-form"),
    search_open = $("#search-open"),
    seach_value = $("[name='search']");

    @Step("Открываем сайт BellIntegrator")
    public StartPage openPage() {
        open("");
        return this;
    }
    @Step("Открываем \"Меню\"")
    public StartPage openMenu() {
        headerMenu.click();
        return this;
    }

    @Step("Открываем \"Поиск\"")
    public StartPage opensearch() {
        search_open.click();
        return this;
    }

    @Step("Заполняем поле \"Поиск\"")
    public StartPage setValueSearch(String search) {
        seach_value.setValue(search).pressEnter();
        return this;
    }

    @Step("Открываем \"Наши Вакансии\"")
    public StartPage openFilterVacancy() {
        filtervacancy.click();
        return this;
    }

    @Step("Выбираем чекбокс \"Горячие вакансии\"")
    public StartPage checkGoryaachee() {
        $("[name='field_goryachee_value']").click();
        return this;
    }

    @Step("Выбираем чекбокс \"Только удаленно\"")
    public StartPage checkUdalenno() {
        $("[name='field_udalennka_value']").click();
        return this;
    }

    @Step("Нажимаем кнопку \"Найти\"")
    public StartPage searchVacancy() {
       exposed_form.find(byText("Найти")).click();;
        return this;
    }

    @Step("Переходим на вкладку \"Вакансии\"")
    public StartPage clickVacancy() {
        vacancy.findBy(Condition.text("Вакансии")).scrollTo();
        sleep(1000);
        vacancy.findBy(Condition.text("Вакансии")).click();
        return this;
    }

    @Step("Переходим в \"Контакты\"")
    public StartPage clickContacts() {
        $("#block-karera").find(byText("Контакты")).click();;
        return this;
    }



}
