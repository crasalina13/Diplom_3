package com.diplom.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.$;

public class RegisterPageObject {

    //локаторы полей регистрации
    @FindAll({@FindBy(how = How.XPATH, using = ".//input")})
    private ElementsCollection inputRegistrationFields;

    //кнопка Регистрация
    @FindBy(how = How.XPATH, using = ".//button[text()='Зарегистрироваться']")
    private SelenideElement buttonRegistration;

    //локатор заголовка Вход
    @FindBy(how = How.XPATH, using = ".//h2[text()='Вход']")
    private SelenideElement headEnter;

    //локатор кнопки Войти
    @FindBy(how = How.XPATH, using = ".//a[text()='Войти']")
    private SelenideElement loginButton;


    //Сообщение об ошибке
    @FindBy(how = How.XPATH, using = ".//p[@class='input__error text_type_main-default' and text()='Некорректный пароль']")
    private SelenideElement errorMessage;

    @Step("Click on registration button")
    public LoginPageObject clickButtonRegistration() {
        $(buttonRegistration).click();
        return Selenide.page(LoginPageObject.class);
    }

    @Step("Click on login button")
    public LoginPageObject clickLoginButton() {
        $(loginButton).click();
        return Selenide.page(LoginPageObject.class);
    }

    @Step("Check incorrect password is visible")
    public boolean isIncorrectPasswordMessage() {
        return $(errorMessage).isDisplayed();
    }

    @Step("Success register user")
    public LoginPageObject successRegistrationNewUser() {
        $(inputRegistrationFields.get(0)).setValue(RandomStringUtils.randomAlphabetic(10));
        $(inputRegistrationFields.get(1)).setValue(RandomStringUtils.randomAlphabetic(10) + "@yandex.ru");
        $(inputRegistrationFields.get(2)).setValue(RandomStringUtils.randomAlphabetic(6));
        $(buttonRegistration).click();
        $(headEnter).shouldBe(Condition.visible);
        return Selenide.page(LoginPageObject.class);
    }

    @Step("Fail register user")
    public RegisterPageObject failRegistrationNewUser() {
        $(inputRegistrationFields.get(0)).setValue(RandomStringUtils.randomAlphabetic(10));
        $(inputRegistrationFields.get(1)).setValue(RandomStringUtils.randomAlphabetic(10) + "@yandex.ru");
        $(inputRegistrationFields.get(2)).setValue(RandomStringUtils.randomAlphabetic(3));
        $(buttonRegistration).click();
        $(errorMessage).shouldBe(Condition.visible);
        return this;
    }
}
