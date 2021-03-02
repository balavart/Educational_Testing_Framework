package razer.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

  private final WebDriver driver;
  private final SearchPage searchPage;

  @FindBy(css = ".top-menu__logo")
  private WebElement mainLogo;

  @FindBy(css = ".top-menu__item--search")
  private WebElement searchButton;

  @FindBy(css = ".search-form__input")
  private WebElement searchElement;

  @FindBy(css = ".trigger-type")
  private WebElement supportTabTrigger;

  @FindBy(css = ".chat-textarea")
  private WebElement supportTabTextBox;

  @FindBy(css = ".close-icon")
  private WebElement supportTabClose;

  @FindBy(css = ".widget-tab")
  private WebElement supportTabBody;

  @FindBy(css = ".syntes-user-icon__icon")
  @CacheLookup
  private WebElement userButton;

  @FindBy(xpath = "//button[contains(.,'Войти')]")
  private WebElement submitButton;

  @FindBy(xpath = "//a[contains(.,'Создать новый аккаунт')]")
  private WebElement createAccountButton;

  @FindBy(css = ".user-dropdown__header")
  private WebElement accountButton;

  public MainPage(WebDriver driver) {
    PageFactory.initElements(driver, this);
    this.driver = driver;
    this.searchPage = new SearchPage(driver);
  }

  @Step
  public String getTitle() {
    return driver.getTitle();
  }

  @Step
  public boolean isLogoDisplayed() {
    return mainLogo.isDisplayed();
  }

  @Step
  public void search(final String text) {
    searchButton.click();
    searchElement.sendKeys(text);
    searchElement.sendKeys(Keys.ENTER);
  }

  @Step
  public void openSupportChat() {
    supportTabTrigger.click();

    new WebDriverWait(driver, 10, 500).until(ExpectedConditions.visibilityOf(supportTabBody));
  }

  @Step
  public void typeSupportChat(final String text) {
    supportTabTextBox.sendKeys(text);
  }

  @Step
  public void closeSupportChat() {
    supportTabClose.click();
  }

  @Step
  public boolean isSupportChatDisplayed() {
    return supportTabBody.isDisplayed();
  }

  public void clickUserButton() {
    userButton.click();
  }

  public void clickSubmitButton() {
    submitButton.click();
  }

  public void clickCreateAccountButton() {
    createAccountButton.click();
  }

  public void clickAccountButton() {
    accountButton.click();
  }

  public SearchPage getSearchPage() {
    return searchPage;
  }
}
