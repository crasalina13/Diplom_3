package com.diplom.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPageObject {

    // Constants
    private static final String ACTIVE_TAB_CLASS = "tab_tab_type_current__2BEPc";

    // Locators ingredients
    @FindBy(how = How.XPATH, using = "//h2[contains(text(),'Булки')]/following-sibling::ul")
    private SelenideElement bunsSection;

    @FindBy(how = How.XPATH, using = "//h2[contains(text(),'Соусы')]/following-sibling::ul")
    private SelenideElement saucesSection;

    @FindBy(how = How.XPATH, using = "//h2[contains(text(),'Начинки')]/following-sibling::ul")
    private SelenideElement fillingsSection;

    @FindBy(xpath = "//span[text()='Булки']/parent::div")
    private SelenideElement bunTab;

    @FindBy(xpath = "//span[text()='Соусы']/parent::div")
    private SelenideElement sauceTab;

    @FindBy(xpath = "//span[text()='Начинки']/parent::div")
    private SelenideElement fillingTab;

    // Base locators
    @FindBy(xpath = "//button[text()='Оформить заказ']")
    private SelenideElement createOrderButton;

    @FindBy(xpath = "//p[text()='Конструктор']")
    private SelenideElement constructButton;

    @FindBy(xpath = "//h1[text()='Соберите бургер']")
    private SelenideElement collectBurgerHeader;

    @FindBy(className = "AppHeader_header__logo__2D0X2")
    private SelenideElement logoButton;

    @FindBy(xpath = "//p[text()='Личный Кабинет']")
    private SelenideElement userAccountButton;

    @FindBy(xpath = "//button[text()='Сохранить']")
    private SelenideElement saveButton;

    @FindBy(xpath = "//button[text()='Войти в аккаунт']")
    private SelenideElement enterAccountButton;

    @FindBy(xpath = "//button[text()='Выход']")
    private SelenideElement logoutButton;

    @FindBy(xpath = "//h2[text()='Вход']")
    private SelenideElement loginHeader;

    // Checks
    @Step("Check order button is visible")
    public boolean isOrderButtonVisible() {
        return createOrderButton.isDisplayed();
    }

    @Step("Check burger header is visible")
    public boolean isCollectBurgerHeaderVisible() {
        return collectBurgerHeader.isDisplayed();
    }

    @Step("Check buns section is visible")
    public boolean isBunsSectionVisible() {
        return bunsSection.isDisplayed();
    }

    @Step("Check sauces section is visible")
    public boolean isSaucesSectionVisible() {
        return saucesSection.isDisplayed();
    }

    @Step("Check fillings section is visible")
    public boolean isFillingsSectionVisible() {
        return fillingsSection.isDisplayed();
    }

    @Step("Check save button is enabled")
    public boolean isSaveButtonEnabled() {
        return saveButton.isEnabled();
    }

    // Steps
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

    @Step("Click bun tab")
    public MainPageObject clickBunTab() {
        bunTab.click();
        checkActiveTab(bunTab);
        return this;
    }

    @Step("Click filling tab")
    public MainPageObject clickFillingTab() {
        fillingTab.click();
        checkActiveTab(fillingTab);
        return this;
    }

    @Step("Click sauce tab")
    public MainPageObject clickSauceTab() {
        sauceTab.click();
        checkActiveTab(sauceTab);
        return this;
    }

    @Step("Click logout button")
    public LoginPageObject clickLogoutButton() {
        logoutButton.click();
        loginHeader.shouldBe(Condition.visible);
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

    @Step("Click user account button")
    public LoginPageObject clickUserAccountButtonWhenUnauthorized() {
        userAccountButton.click();
        return Selenide.page(LoginPageObject.class);
    }

    @Step("Check active tab")
    private void checkActiveTab(SelenideElement tabElement) {
        tabElement.shouldHave(Condition.cssClass(ACTIVE_TAB_CLASS));
    }
}