import helpers.Attach;
import org.junit.jupiter.api.*;
import page.ContactPage;
import page.SearchPage;
import page.StartPage;
import page.VacancyPage;

public class TestsSoftportal extends TestsBase {

    StartPage startPage = new StartPage();
    ContactPage contactPage = new ContactPage();
    VacancyPage vacancyPage = new VacancyPage();
    SearchPage searchPage = new SearchPage();

    @DisplayName("Поиск Контакты")
    @Tag("bi_test")
    @Test
    void searchContactsTests(){
        startPage.openPage()
                .openMenu()
                .clickContacts();
        contactPage.searchPhone();
    }

    @DisplayName("Переход на сайт Вакансии")
    @Tag("bi_test")
    @Test
    void searchVacancyTests(){
        startPage.openPage()
                .clickVacancy();
        vacancyPage.vacancyPageText();
    }

    @DisplayName("Поиск горячих вакансии")
    @Tag("bi_test")
    @Test
    void searchGoryacheeVacancyTests(){
        startPage.openPage()
                .openFilterVacancy()
                .checkGoryaachee()
                .searchVacancy();
        vacancyPage.checkboxGoryachee();
    }

    @DisplayName("Поиск удаленных вакансии")
    @Tag("bi_test")
    @Test
    void searchUdalennoVacancyTests(){
        startPage.openPage()
                .openFilterVacancy()
                .checkUdalenno()
                .searchVacancy();
        vacancyPage.checkboxUdalenno();
    }

    @DisplayName("Проверка поиска по странице")
    @Tag("bi_test")
    @Test
    void searchResultsTest(){
        String search = "Тестирование";
        startPage.openPage()
                .opensearch()
                .setValueSearch(search);
        searchPage.searchResults(search);
    }






}
