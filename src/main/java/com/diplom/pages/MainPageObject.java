package com.diplom.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.$;

public class MainPageObject {

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
    private ElementsCollection ingredientsList;

    //локатор кнопки Конструктор
    @FindBy(how = How.XPATH, using = ".//p[text()='Конструктор']")
    private SelenideElement constructButton;

    //локатор заголовка Соберите бургер
    @FindBy(how = How.XPATH, using = ".//h1[text()='Соберите бургер']")
    private SelenideElement collectBurgerHeader;

    //локатор logo
    @FindBy(how = How.XPATH, using = ".//div[@class='AppHeader_header__logo__2D0X2']")
    private SelenideElement logoButton;

    //локатор кнопки Личный кабинет
    @FindBy(how = How.XPATH, using = ".//p[text()='Личный Кабинет']")
    private SelenideElement userAccountButton;

    //локатор кнопки Сохранить
    @FindBy(how = How.XPATH, using = ".//button[text()='Сохранить']")
    private SelenideElement saveButton;

    //локатор кнопки войти в аккаунт
    @FindBy(how = How.XPATH, using = ".//button[text()='Войти в аккаунт']")
    private SelenideElement enterAccountButton;

    //локатор кнопки выход
    @FindBy(how = How.XPATH, using = ".//button[text()='Выход']")
    private SelenideElement logoutButton;

    //локатор Заголовка Вход
    @FindBy(how = How.XPATH, using = ".//h2[text()='Вход']")
    private SelenideElement headEnter;

    @Step("Check order button is visible")
    public boolean isOrderButtonVisible() {
        return createOrderButton.isDisplayed();
    }

    @Step("Check burger header is visible")
    public boolean isCollectBurgerHeaderVisible() {
        return collectBurgerHeader.isDisplayed();
    }

    @Step("Check ingredients list bun is visible")
    public boolean isIngredientsListBunVisible() {
        return ingredientsList.get(0).isDisplayed();
    }

    @Step("Check ingredients list sauce is visible")
    public boolean isIngridientsListSauceVisible() {
        return ingredientsList.get(1).isDisplayed();
    }

    @Step("Check ingredients fillings is visible")
    public boolean isIngredientsFillingBunVisible() {
        return ingredientsList.get(2).isDisplayed();
    }

    @Step("Check save button is enabled")
    public boolean isSaveButtonEnabled() {
        return saveButton.isEnabled();
    }

    @Step("Click login button")
    public LoginPageObject clickEnterAccountButton() {
        enterAccountButton.click();
        return Selenide.page(LoginPageObject.class);
    }

    @Step("Click construct button")
    public MainPageObject clickConstructButton() {
        constructButton.click();
        return this;
    }

    @Step("Click bun button")
    public MainPageObject clickBunButton() {
        bunButton.click();
        checkActiveTab();
        return this;
    }

    @Step("Click filling button")
    public MainPageObject clickFillingButton() {
        fillingButton.click();
        checkActiveTab();
        return this;
    }

    @Step("Click sauce button")
    public MainPageObject clickSauceButton() {
        sauceButton.click();
        checkActiveTab();
        return this;
    }

    @Step("Click logout button")
    public LoginPageObject clickLogoutButton() {
        logoutButton.click();
        headEnter.shouldBe(Condition.visible);
        return Selenide.page(LoginPageObject.class);
    }

    @Step("Click user account button")
    public MainPageObject clickUserAccountButton() {
        userAccountButton.click();
        return this;
    }

    @Step("Click logo button")
    public MainPageObject clickLogoButton() {
        logoButton.click();
        return this;
    }

    public LoginPageObject clickUserAccountButtonIsAuth() {
        userAccountButton.click();
        return Selenide.page(LoginPageObject.class);
    }

    @Step("Check if the active tab has the specified class")
    private void checkActiveTab() {
        SelenideElement activeTab = $("div[class*='" + "tab_tab_type_current__2BEPc" + "']");
        activeTab.shouldBe(Condition.visible);
    }
}

