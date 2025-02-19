package PageObject;

import base.UserOperations;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class LoginPageObject {
    public static final String URL = "https://stellarburgers.nomoreparties.site/login";

    //локатор Заголовка Вход
    @FindBy(how = How.XPATH, using = ".//h2[text()='Вход']")
    private SelenideElement headEnter;

    //локатор кнопки Войти
    @FindBy(how = How.XPATH, using = ".//button[text()='Войти']")
    private SelenideElement loginButton;

    //локатор кнопки Оформить заказ
    @FindBy(how = How.XPATH, using = ".//button[text()='Оформить заказ']")
    private SelenideElement createOrderButton;

    //локаторы полей логина
    @FindAll({@FindBy(how = How.XPATH, using = ".//input")})
    private ElementsCollection inputLoginFields;

    //проверка видимости Заголовка Вход
    public boolean isLoginButtonVisible() {
        return $(headEnter).isDisplayed();
    }

    //метод успешного логина
    public MainPageObject successLoginUser(UserOperations userOperations) {
        List userData = new ArrayList(userOperations.register().values());
        String email = userData.get(2).toString();
        String password = userData.get(0).toString();
        $(inputLoginFields.get(0).setValue(email));
        $(inputLoginFields.get(1).setValue(password));
        $(loginButton).click();
        createOrderButton.shouldBe(Condition.visible);
        return page(MainPageObject.class);
    }
}

