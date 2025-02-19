package YandexBrowserTest;

import PageObject.RegisterPageObject;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;

public class RegisterPageTest {

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/yandexdriver");
    }

    @Test
    public void checkSuccessRegistration() {
        final boolean isLoginButtonVisible = open(RegisterPageObject.URL, RegisterPageObject.class)
                .successRegistrationNewUser()
                .isLoginButtonVisible();
        assertTrue("Login button is not displayed", isLoginButtonVisible);
    }

    @Test
    public void checkFailRegistration() {
        final boolean isIncorrectPasswordMessage = open(RegisterPageObject.URL, RegisterPageObject.class)
                .failRegistrationNewUser()
                .isIncorrectPasswordMessage();
        assertTrue("Error message is not displayed", isIncorrectPasswordMessage);
    }
}