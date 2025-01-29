package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class StartPage {

    private ElementsCollection vacancy = $$(".container-fluid a");
    private SelenideElement  headerMenu = $(".text-end.d-flex.align-items-center a img");

    @Step("Открываем сайт BellIntegrator")
    public StartPage openPage() {
        open("");
        return this;
    }

    @Step("Переходим на вкладку \"Вакансии\"")
    public StartPage clickVacancy() {
        vacancy.findBy(Condition.text("Вакансии")).scrollTo();
        sleep(1000);
        vacancy.findBy(Condition.text("Вакансии")).click();
        return this;
    }

    @Step("Открываем \"Меню\"")
    public StartPage openMenu() {
        headerMenu.click();
        return this;
    }
    @Step("Открываем \"Меню\"")
    public StartPage clickContacts() {
        $("#block-karera").find(byText("Контакты")).click();;
        return this;
    }


}
