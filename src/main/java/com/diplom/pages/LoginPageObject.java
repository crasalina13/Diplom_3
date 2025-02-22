package com.diplom.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.diplom.UserOperations;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.page;

public class LoginPageObject {
    // Локатор заголовка "Вход"
    @FindBy(how = How.XPATH, using = ".//h2[text()='Вход']")
    private SelenideElement headEnter;

    // Локатор кнопки "Войти"
    @FindBy(how = How.XPATH, using = ".//button[text()='Войти']")
    private SelenideElement loginButton;

    // Локатор кнопки "Оформить заказ"
    @FindBy(how = How.XPATH, using = ".//button[text()='Оформить заказ']")
    private SelenideElement createOrderButton;

    // Локаторы полей логина
    @FindAll({@FindBy(how = How.XPATH, using = ".//input")})
    private ElementsCollection inputLoginFields;

    @Step("Check if the login header is visible")
    public boolean isLoginHeaderVisible() {
        return headEnter.isDisplayed();
    }

    @Step("Enter email: {email}")
    public void enterEmail(String email) {
        inputLoginFields.get(0).setValue(email);
    }

    @Step("Enter password")
    public void enterPassword(String password) {
        inputLoginFields.get(1).setValue(password);
    }

    @Step("Click on the login button")
    public void clickLoginButton() {
        loginButton.click();
    }

    @Step("Check if the create order button is visible")
    public boolean isCreateOrderButtonVisible() {
        return createOrderButton.shouldBe(Condition.visible).isDisplayed();
    }

    @Step("Successful login for user")
    public MainPageObject successLoginUser(UserOperations userOperations) {
        List userData = new ArrayList(userOperations.register().values());
        String email = userData.get(2).toString();
        String password = userData.get(0).toString();

        enterEmail(email);
        enterPassword(password);
        clickLoginButton();

        if (isCreateOrderButtonVisible()) {
            return page(MainPageObject.class);
        } else {
            throw new RuntimeException("Login failed: Create order button is not visible.");
        }
    }
}
