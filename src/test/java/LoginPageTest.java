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
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;

public class LoginPageTest {

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
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    public void checkSuccessLoginViaMainPageButton() {
        boolean isOrderButtonVisible = open(Endpoints.MAIN_PATH.getPath(), MainPageObject.class)
                .clickEnterAccountButton()
                .successLoginUser(userOperations)
                .isOrderButtonVisible();
        assertTrue("Кнопка оформления заказа не отображается", isOrderButtonVisible);
    }

    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»")
    public void checkSuccessLoginViaProfileButton() {
        boolean isOrderButtonVisible = open(Endpoints.MAIN_PATH.getPath(), MainPageObject.class)
                .clickUserAccountButtonWhenUnauthorized()
                .successLoginUser(userOperations)
                .isOrderButtonVisible();
        assertTrue("Кнопка оформления заказа не отображается", isOrderButtonVisible);
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void checkSuccessLoginFromRegistrationPage() {
        boolean isOrderButtonVisible = open(Endpoints.REGISTER_PATH.getPath(), RegisterPageObject.class)
                .clickLoginButton()
                .successLoginUser(userOperations)
                .isOrderButtonVisible();
        assertTrue("Кнопка оформления заказа не отображается", isOrderButtonVisible);
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    public void checkSuccessLoginFromPasswordRecoveryPage() {
        boolean isOrderButtonVisible = open(Endpoints.FORGOT_PASSWORD_PATH.getPath(), ForgotPasswordPageObject.class)
                .clickLoginButton()
                .successLoginUser(userOperations)
                .isOrderButtonVisible();
        assertTrue("Кнопка оформления заказа не отображается", isOrderButtonVisible);
    }
}