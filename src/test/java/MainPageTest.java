import com.diplom.BrowserFactory;
import com.diplom.Endpoints;
import com.diplom.UserOperations;
import com.diplom.pages.MainPageObject;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.open;
import static com.diplom.BrowserFactory.BrowserType.CHROME;
import static com.diplom.BrowserFactory.BrowserType.YANDEX;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class MainPageTest {

    private UserOperations userOperations;
    private WebDriver driver;
    private final BrowserFactory.BrowserType browser;

    @Parameterized.Parameters(name = "Browser: {0}")
    public static Object[] data() {
        return new Object[]{CHROME, YANDEX};
    }

    public MainPageTest(BrowserFactory.BrowserType browser) {
        this.browser = browser;
    }

    @Before
    public void setUp() {
        userOperations = new UserOperations();
        driver = BrowserFactory.getDriver(browser);
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
        final boolean isingridientsListBunVisible = open(Endpoints.MAIN_PATH.getPath(), MainPageObject.class)
                .clickEnterAccountButton()
                .successLoginUser(userOperations)
                .clickFillingButton()
                .clickBunButton()
                .isIngredientsListBunVisible();
        assertTrue("Bun list  is not displayed", isingridientsListBunVisible);
    }

    @Test
    @DisplayName("Переход по клику на соусы")
    public void checkGoSauce() {
        final boolean isIngridientsListSauceVisible = open(Endpoints.MAIN_PATH.getPath(), MainPageObject.class)
                .clickEnterAccountButton()
                .successLoginUser(userOperations)
                .clickSauceButton()
                .isIngridientsListSauceVisible();
        assertTrue("Sauce list is not displayed", isIngridientsListSauceVisible);
    }

    @Test
    @DisplayName("Переход по клику на начинки")
    public void checkGoFilling() {
        final boolean isIngridientsFillingBunVisible = open(Endpoints.MAIN_PATH.getPath(), MainPageObject.class)
                .clickEnterAccountButton()
                .successLoginUser(userOperations)
                .clickFillingButton()
                .isIngredientsFillingBunVisible();
        assertTrue("Filling list  is not displayed", isIngridientsFillingBunVisible);
    }
}
