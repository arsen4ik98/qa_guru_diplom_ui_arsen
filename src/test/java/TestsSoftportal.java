import org.junit.jupiter.api.*;
import page.ContactPage;
import page.StartPage;

public class TestsSoftportal extends TestsBase {

    StartPage startPage = new StartPage();
    ContactPage contactPage = new ContactPage();


    @DisplayName("Поиск Контакты")
    @Tag("bi_test")
    @Test
    void searchContactsTests(){
        startPage.openPage()
                .openMenu()
                .clickContacts();
        contactPage.searchPhone();
    }






}
