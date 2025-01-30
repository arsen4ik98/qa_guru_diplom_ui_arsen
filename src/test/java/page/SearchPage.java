package page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class SearchPage {

    private SelenideElement searchResults = $(".search-results");

    @Step("Результат поиска")
    public SearchPage searchResults(String search) {
        searchResults.shouldHave(text(search));
        return this;
    }

}
