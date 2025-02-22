import com.diplom.BrowserFactory;
import com.diplom.Endpoints;
import com.diplom.UserOperations;
import com.diplom.pages.ForgotPasswordPageObject;
import com.diplom.pages.MainPageObject;
import com.diplom.pages.RegisterPageObject;
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
public class LoginPageTest {

    private UserOperations userOperations;
    private WebDriver driver;
    private final BrowserFactory.BrowserType browser;

    @Parameterized.Parameters(name = "Browser: {0}")
    public static Object[] data() {
        return new Object[]{CHROME, YANDEX};
    }

    public LoginPageTest(BrowserFactory.BrowserType browser) {
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
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    public void checkSuccessLoginInButtonEnterAccount() {
        final boolean isOrderButtonVisible = open(Endpoints.MAIN_PATH.getPath(), MainPageObject.class)
                .clickEnterAccountButton()
                .successLoginUser(userOperations)
                .isOrderButtonVisible();
        assertTrue("Order button is not displayed", isOrderButtonVisible);
    }

    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»")
    public void checkSuccessLoginInButtonUserAccount() {
        final boolean isOrderButtonVisible = open(Endpoints.MAIN_PATH.getPath(), MainPageObject.class)
                .clickUserAccountButtonIsAuth()
                .successLoginUser(userOperations)
                .isOrderButtonVisible();
        assertTrue("Order button is not displayed", isOrderButtonVisible);
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void checkSuccessLoginInLogin() {
        final boolean isOrderButtonVisible = open(Endpoints.REGISTER_PATH.getPath(), RegisterPageObject.class)
                .clickLoginButton()
                .successLoginUser(userOperations)
                .isOrderButtonVisible();
        assertTrue("Order button is not displayed", isOrderButtonVisible);
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    public void checkSuccessLoginInLoginButton() {
        final boolean isOrderButtonVisible = open(Endpoints.FORGOT_PASSWORD_PATH.getPath(), ForgotPasswordPageObject.class)
                .clickLoginButton()
                .successLoginUser(userOperations)
                .isOrderButtonVisible();
        assertTrue("Order button is not displayed", isOrderButtonVisible);
    }
}
