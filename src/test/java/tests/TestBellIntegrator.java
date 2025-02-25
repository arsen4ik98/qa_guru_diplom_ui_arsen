package tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.*;
import page.ContactPage;
import page.SearchPage;
import page.StartPage;
import page.VacancyPage;

@Tag("bi_test")
@Owner("arsen4ik98")

public class TestBellIntegrator extends TestsBase {

    StartPage startPage = new StartPage();
    ContactPage contactPage = new ContactPage();
    VacancyPage vacancyPage = new VacancyPage();
    SearchPage searchPage = new SearchPage();

    @DisplayName("Проверка поиска Контакты")
    @Test
    void searchContactsTests(){
        startPage.openPage()
                .openMenu()
                .clickContacts();
        contactPage.searchPhone();
    }

    @DisplayName("Проверка перехода на сайт Вакансии")
    @Test
    void searchVacancyTests(){
        startPage.openPage()
                .clickVacancy();
        vacancyPage.vacancyPageText();
    }

    @DisplayName("Проверка поиска горячих вакансии")
    @Test
    void searchGoryacheeVacancyTests(){
        startPage.openPage()
                .openFilterVacancy()
                .checkGoryaachee()
                .searchVacancy();
        vacancyPage.checkboxGoryachee();
    }

    @DisplayName("Проверка поиска по специализации")
    @Test
    void searchSpecializationVacancyTests(){
        startPage.openPage()
                .clickVacancy();
        vacancyPage.clickToSpecializationBtn()
                .chooseSpecializationOption("Вакансии тестировщиков")
                .clickSearch();
    }

    @DisplayName("Проверка поиска по Локации")
    @Test
    void searchLocationVacancyTests(){
        startPage.openPage()
                .clickVacancy();
        vacancyPage.clickToLocationBtn()
                .chooseLocationOption("Москва")
                .clickSearch();
    }

    @DisplayName("Проверка поиска удаленных вакансии")
    @Test
    void searchUdalennoVacancyTests(){
        startPage.openPage()
                .openFilterVacancy()
                .checkUdalenno()
                .searchVacancy();
        vacancyPage.checkboxUdalenno();
    }


    @DisplayName("Проверка поиска по странице")
    @Test
    void searchResultsTest(){
        String search = "Тестирование";
        startPage.openPage()
                .opensearch()
                .setValueSearch(search);
        searchPage.searchResults(search);
    }
}
