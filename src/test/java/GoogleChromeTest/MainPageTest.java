package GoogleChromeTest;

import PageObject.MainPageObject;
import base.UserOperations;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;

public class MainPageTest {
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
    public void checkSuccessLogout() {
        final boolean isLoginButtonVisible = open(MainPageObject.URL, MainPageObject.class)
                .clickEnterAccountButton()
                .successLoginUser(userOperations)
                .clickUserAccountButton()
                .clickLogoutButton()
                .isLoginButtonVisible();
        assertTrue("Login button is not displayed", isLoginButtonVisible);
    }

    @Test
    public void checkGoConstructLogoButton() {
        final boolean isСoolectBurgerHeaderVisible = open(MainPageObject.URL, MainPageObject.class)
                .clickEnterAccountButton()
                .successLoginUser(userOperations)
                .clickUserAccountButton()
                .clickLogoButton()
                .isСoolectBurgerHeaderVisible();
        assertTrue("Construct header is not displayed", isСoolectBurgerHeaderVisible);
    }

    @Test
    public void checkGoConstructConstructButton() {
        final boolean isСoolectBurgerHeaderVisible = open(MainPageObject.URL, MainPageObject.class)
                .clickEnterAccountButton()
                .successLoginUser(userOperations)
                .clickUserAccountButton()
                .clickConstructButton()
                .isСoolectBurgerHeaderVisible();
        assertTrue("Construct header is not displayed", isСoolectBurgerHeaderVisible);
    }

    @Test
    public void checkGoBun() {
        final boolean isingridientsListBunVisible = open(MainPageObject.URL, MainPageObject.class)
                .clickEnterAccountButton()
                .successLoginUser(userOperations)
                .clickFillingButton()
                .clickBunButton()
                .isIngridientsListBunVisible();
        assertTrue("Bun list  is not displayed", isingridientsListBunVisible);
    }

    @Test
    public void checkGoSauce() {
        final boolean isIngridientsListSauceVisible = open(MainPageObject.URL, MainPageObject.class)
                .clickEnterAccountButton()
                .successLoginUser(userOperations)
                .clickSauceButton()
                .isIngridientsListSauceVisible();
        assertTrue("Sauce list is not displayed", isIngridientsListSauceVisible);
    }

    @Test
    public void checkGoFilling() {
        final boolean isIngridientsFillingBunVisible = open(MainPageObject.URL, MainPageObject.class)
                .clickEnterAccountButton()
                .successLoginUser(userOperations)
                .clickFillingButton()
                .isIngridientsFillingBunVisible();
        assertTrue("Filling list  is not displayed", isIngridientsFillingBunVisible);
    }
}

