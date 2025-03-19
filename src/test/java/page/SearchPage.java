package page;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.CollectionCondition.allMatch;
import static com.codeborne.selenide.Selenide.*;

public class SearchPage {

    private ElementsCollection searchResults = $$(".search-results .search-result__snippet");

    @Step("Результат поиска")
    public SearchPage checkSearchResults(String search) {
        searchResults.shouldHave(allMatch(search,
                element -> element.getText().toLowerCase().contains(search.toLowerCase())));
        return this;
    }
}
