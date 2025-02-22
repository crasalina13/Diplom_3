import com.diplom.BrowserFactory;
import com.diplom.Endpoints;
import com.diplom.pages.RegisterPageObject;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;

public class RegisterPageTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        driver = BrowserFactory.getDriver();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @DisplayName("Успешная регистрация")
    public void checkSuccessRegistration() {
        final boolean isLoginButtonVisible = open(Endpoints.REGISTER_PATH.getPath(), RegisterPageObject.class)
                .successRegistrationNewUser()
                .isLoginHeaderVisible();
        assertTrue("Login button is not displayed", isLoginButtonVisible);
    }

    @Test
    @DisplayName("Ошибка при регистрации для некорректного пароля")
    public void checkFailRegistration() {
        final boolean isIncorrectPasswordMessage = open(Endpoints.REGISTER_PATH.getPath(), RegisterPageObject.class)
                .failRegistrationNewUser()
                .isIncorrectPasswordMessage();
        assertTrue("Error message is not displayed", isIncorrectPasswordMessage);
    }
}
