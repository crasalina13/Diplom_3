package GoogleChromeTest;

import PageObject.ForgotPasswordPageObject;
import PageObject.MainPageObject;
import PageObject.RegisterPageObject;
import base.UserOperations;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;

public class LoginPageTest {
    private UserOperations userOperations;

    @Before
    public void setUp() {
        userOperations = new UserOperations();
    }

    @After
    public void tearDown() {
        userOperations.delete();
    }

    @Test
    public void checkSuccessLoginInButtonEnterAccount() {
        final boolean isOrderButtonVisible = open(MainPageObject.URL, MainPageObject.class)
                .clickEnterAccountButton()
                .successLoginUser(userOperations)
                .isOrderButtonVisible();
        assertTrue("Order button is not displayed", isOrderButtonVisible);
    }

    @Test
    public void checkSuccessLoginInButtonUserAccount() {
        final boolean isOrderButtonVisible = open(MainPageObject.URL, MainPageObject.class)
                .clickUserAccountButtonIsAuth()
                .successLoginUser(userOperations)
                .isOrderButtonVisible();
        assertTrue("Order button is not displayed", isOrderButtonVisible);
    }

    @Test
    public void checkSuccessLoginInLogin() {
        final boolean isOrderButtonVisible = open(RegisterPageObject.URL, RegisterPageObject.class)
                .clickLoginButton()
                .successLoginUser(userOperations)
                .isOrderButtonVisible();
        assertTrue("Order button is not displayed", isOrderButtonVisible);
    }

    @Test
    public void checkSuccessLoginInLoginButton() {
        final boolean isOrderButtonVisible = open(ForgotPasswordPageObject.URL, ForgotPasswordPageObject.class)
                .clickLoginButton()
                .successLoginUser(userOperations)
                .isOrderButtonVisible();
        assertTrue("Order button is not displayed", isOrderButtonVisible);
    }
}
