package page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StartPage {

    private SelenideElement vacancy = $(".btn-danger"),
            headerMenu = $(".menu-icons-right");

    @Step("Открываем сайт BellIntegrator")
    public StartPage openPage() {
        open("");
        return this;
    }

    @Step("Переходим на вкладку \"Вакансии\"")
    public StartPage clickVacancy() {
        vacancy.$(byText("Вакансии")).click();
        return this;
    }

    @Step("Открываем \"Меню\"")
    public StartPage openMenu() {
        headerMenu.click();
        return this;
    }
    @Step("Открываем \"Меню\"")
    public StartPage clickContacts() {
        $(".nav-item").$(byText("Контакты")).click();;
        return this;
    }


}
