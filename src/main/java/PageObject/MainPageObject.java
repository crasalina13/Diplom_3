package PageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class MainPageObject {
    public static final String URL = "https://stellarburgers.nomoreparties.site";

    //локатор кнопки Оформить заказ
    @FindBy(how = How.XPATH, using = ".//button[text()='Оформить заказ']")
    private SelenideElement createOrderButton;

    //локатор кнопки Булки
    @FindBy(how = How.XPATH, using = "//span[text()='Булки']")
    private SelenideElement bunButton;

    //локатор кнопки Начинки
    @FindBy(how = How.XPATH, using = ".//span[text()='Начинки']")
    private SelenideElement fillingButton;

    //локатор кнопки Соусы
    @FindBy(how = How.XPATH, using = ".//span[text()='Соусы']")
    private SelenideElement sauceButton;

    //локаторы полей ингридиентов
    @FindAll({@FindBy(how = How.XPATH, using = ".//ul[@class='BurgerIngredients_ingredients__list__2A-mT']")})
    private ElementsCollection ingridientsList;

    //локатор кнопки Конструктор
    @FindBy(how = How.XPATH, using = ".//p[text()='Конструктор']")
    private SelenideElement constructButton;

    //локатор заголовка Соберите бургер
    @FindBy(how = How.XPATH, using = ".//h1[text()='Соберите бургер']")
    private SelenideElement coolectBurgerHeader;

    //локатор logo
    @FindBy(how = How.XPATH, using = ".//div[@class='AppHeader_header__logo__2D0X2']")
    private SelenideElement logoButton;

    //локатор кнопки Личный кабинет
    @FindBy(how = How.XPATH, using = ".//p[text()='Личный Кабинет']")
    private SelenideElement userAccountButton;

    //локатор кнопки войти в аккаунт
    @FindBy(how = How.XPATH, using = ".//button[text()='Войти в аккаунт']")
    private SelenideElement enterAccountButton;

    //локатор кнопки выход
    @FindBy(how = How.XPATH, using = ".//button[text()='Выход']")
    private SelenideElement logoutButton;

    //локатор Заголовка Вход
    @FindBy(how = How.XPATH, using = ".//h2[text()='Вход']")
    private SelenideElement headEnter;

    //проверка видимости кнопки Оформить заказ
    public boolean isOrderButtonVisible() {
        return $(createOrderButton).isDisplayed();
    }

    //проверка видимости заголовка Соберите бургер
    public boolean isСoolectBurgerHeaderVisible() {
        return $(coolectBurgerHeader).isDisplayed();
    }

    //проверка видимости ингридиенты булки
    public boolean isIngridientsListBunVisible() {
        return $(ingridientsList.get(0)).isDisplayed();
    }

    //проверка видимости ингридиенты соусы
    public boolean isIngridientsListSauceVisible() {
        return $(ingridientsList.get(1)).isDisplayed();
    }

    //проверка видимости ингридиенты начинки
    public boolean isIngridientsFillingBunVisible() {
        return $(ingridientsList.get(2)).isDisplayed();
    }

    //клик на кнопку войти в аккаунт
    public LoginPageObject clickEnterAccountButton() {
        enterAccountButton.click();
        return page(LoginPageObject.class);
    }

    //клик на кнопку Конструктор
    public MainPageObject clickConstructButton() {
        constructButton.click();
        return this;
    }

    //клик на кнопку Булки
    public MainPageObject clickBunButton() {
        bunButton.click();
        ingridientsList.get(0).shouldBe(Condition.visible);
        return this;
    }

    //клик на кнопку Начинки
    public MainPageObject clickFillingButton() {
        fillingButton.click();
        ingridientsList.get(2).shouldBe(Condition.visible);
        return this;
    }

    //клик на кнопку Соусы
    public MainPageObject clickSauceButton() {
        sauceButton.click();
        ingridientsList.get(1).shouldBe(Condition.visible);
        return this;
    }

    //клик на кнопку выход
    public LoginPageObject clickLogoutButton() {
        logoutButton.click();
        headEnter.shouldBe(Condition.visible);
        return page(LoginPageObject.class);
    }

    //клик на кнопку личный кабинет
    public MainPageObject clickUserAccountButton() {
        userAccountButton.click();
        return this;
    }

    //клик на кнопку  logo
    public MainPageObject clickLogoButton() {
        logoButton.click();
        return this;
    }

    public LoginPageObject clickUserAccountButtonIsAuth() {
        userAccountButton.click();
        return page(LoginPageObject.class);
    }
}
