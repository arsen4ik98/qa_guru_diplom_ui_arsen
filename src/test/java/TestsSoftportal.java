import helpers.Attach;
import org.junit.jupiter.api.*;
import page.ContactPage;
import page.StartPage;
import page.VacancyPage;

public class TestsSoftportal extends TestsBase {

    StartPage startPage = new StartPage();
    ContactPage contactPage = new ContactPage();
    VacancyPage vacancyPage = new VacancyPage();

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






}
