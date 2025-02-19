package PageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class RegisterPageObject {
    public static final String URL = "https://stellarburgers.nomoreparties.site/register";

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

    //метод клика на кнопку Регистрации
    public LoginPageObject clickButtonRegistration() {
        $(buttonRegistration).click();
        return page(LoginPageObject.class);
    }

    //метод клика на кнопку Войти
    public LoginPageObject clickLoginButton() {
        $(loginButton).click();
        return page(LoginPageObject.class);
    }

    //проверка видимости сообщения Некорректный пароль
    public boolean isIncorrectPasswordMessage() {
        return $(errorMessage).isDisplayed();
    }

    //методы успешной регистрации
    public LoginPageObject successRegistrationNewUser() {
        $(inputRegistrationFields.get(0)).setValue(RandomStringUtils.randomAlphabetic(10));
        $(inputRegistrationFields.get(1)).setValue(RandomStringUtils.randomAlphabetic(10) + "@yandex.ru");
        $(inputRegistrationFields.get(2)).setValue(RandomStringUtils.randomAlphabetic(6));
        $(buttonRegistration).click();
        $(headEnter).shouldBe(Condition.visible);
        return page(LoginPageObject.class);
    }

    //метод неуспешной регистрации
    public RegisterPageObject failRegistrationNewUser() {
        $(inputRegistrationFields.get(0)).setValue(RandomStringUtils.randomAlphabetic(10));
        $(inputRegistrationFields.get(1)).setValue(RandomStringUtils.randomAlphabetic(10) + "@yandex.ru");
        $(inputRegistrationFields.get(2)).setValue(RandomStringUtils.randomAlphabetic(3));
        $(buttonRegistration).click();
        $(errorMessage).shouldBe(Condition.visible);
        return this;
    }
}
