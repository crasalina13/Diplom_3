import com.diplom.BrowserFactory;
import com.diplom.Endpoints;
import com.diplom.UserOperations;
import com.diplom.pages.MainPageObject;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;

public class MainPageTest {

    private UserOperations userOperations;
    private WebDriver driver;

    @Before
    public void setUp() {
        userOperations = new UserOperations();
        driver = BrowserFactory.getDriver();
    }

    @After
    public void tearDown() {
        userOperations.delete();
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @DisplayName("Выход по кнопке «Выйти» в личном кабинете")
    public void checkSuccessLogout() {
        final boolean isLoginButtonVisible = open(Endpoints.MAIN_PATH.getPath(), MainPageObject.class)
                .clickEnterAccountButton()
                .successLoginUser(userOperations)
                .clickUserAccountButton()
                .clickLogoutButton()
                .isLoginHeaderVisible();
        assertTrue("Login button is not displayed", isLoginButtonVisible);
    }

    @Test
    @DisplayName("Переход на логотип Stellar Burgers")
    public void checkGoConstructLogoButton() {
        final boolean isCollectBurgerHeaderVisible = open(Endpoints.MAIN_PATH.getPath(), MainPageObject.class)
                .clickEnterAccountButton()
                .successLoginUser(userOperations)
                .clickUserAccountButton()
                .clickLogoButton()
                .isCollectBurgerHeaderVisible();
        assertTrue("Construct header is not displayed", isCollectBurgerHeaderVisible);
    }

    @Test
    @DisplayName("Проверь переход по клику на «Личный кабинет»")
    public void checkGoAccountButton() {
        final boolean isSaveButtonVisible = open(Endpoints.MAIN_PATH.getPath(), MainPageObject.class)
                .clickEnterAccountButton()
                .successLoginUser(userOperations)
                .clickUserAccountButton()
                .isSaveButtonEnabled();
        assertTrue("Save button is enabled", isSaveButtonVisible);
    }

    @Test
    @DisplayName("Переход по клику на «Конструктор»")
    public void checkGoConstructConstructButton() {
        final boolean isCollectBurgerHeaderVisible = open(Endpoints.MAIN_PATH.getPath(), MainPageObject.class)
                .clickEnterAccountButton()
                .successLoginUser(userOperations)
                .clickUserAccountButton()
                .clickConstructButton()
                .isCollectBurgerHeaderVisible();
        assertTrue("Construct header is not displayed", isCollectBurgerHeaderVisible);
    }

    @Test
    @DisplayName("Переход по клику на булки")
    public void checkGoBun() {
        final boolean isBunsSectionVisible = open(Endpoints.MAIN_PATH.getPath(), MainPageObject.class)
                .clickEnterAccountButton()
                .successLoginUser(userOperations)
                .clickFillingTab()
                .clickBunTab()
                .isBunsSectionVisible();
        assertTrue("Buns section is not displayed", isBunsSectionVisible);
    }

    @Test
    @DisplayName("Переход по клику на соусы")
    public void checkGoSauce() {
        final boolean isSaucesSectionVisible = open(Endpoints.MAIN_PATH.getPath(), MainPageObject.class)
                .clickEnterAccountButton()
                .successLoginUser(userOperations)
                .clickSauceTab()
                .isSaucesSectionVisible();
        assertTrue("Sauces section is not displayed", isSaucesSectionVisible);
    }

    @Test
    @DisplayName("Переход по клику на начинки")
    public void checkGoFilling() {
        final boolean isFillingsSectionVisible = open(Endpoints.MAIN_PATH.getPath(), MainPageObject.class)
                .clickEnterAccountButton()
                .successLoginUser(userOperations)
                .clickFillingTab()
                .isFillingsSectionVisible();
        assertTrue("Fillings section is not displayed", isFillingsSectionVisible);
    }
}