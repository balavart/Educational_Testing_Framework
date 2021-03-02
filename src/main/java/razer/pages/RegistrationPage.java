package razer.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {

  @FindBy(xpath = "//span[text()='Ваше имя']/following::input[1]")
  private WebElement nameInput;

  @FindBy(xpath = "//span[text()='Ваша фамилия']/following::input[1]")
  private WebElement surnameInput;

  @FindBy(xpath = "//span[text()='E-mail']/following::input[1]")
  private WebElement emailInput;

  @FindBy(xpath = "//span[text()='Телефон']/following::input[1]")
  private WebElement phoneNumberInput;

  @FindBy(xpath = "//span[text()='Пароль']/following::input[1]")
  private WebElement newPasswordInput;

  @FindBy(xpath = "//span[text()='Повторите пароль']/following::input[1]")
  private WebElement repeatPasswordInput;

  @FindBy(xpath = "//iframe[@role='presentation']")
  private WebElement reCaptcha;

  @FindBy(css = ".syntes-store-account__register")
  private WebElement registrationButton;

  public RegistrationPage(WebDriver driver) {
    PageFactory.initElements(driver, this);
  }

  public void typeInputNewName(String text) {
    nameInput.sendKeys(text);
  }

  public void typeInputSurname(String text) {
    surnameInput.sendKeys(text);
  }

  public void typeInputEmail(String text) {
    emailInput.sendKeys(text);
  }

  public void typeInputPhoneNumber(String text) {
    phoneNumberInput.sendKeys(text);
  }

  public void typeInputNewPasswordInput(String text) {
    newPasswordInput.sendKeys(text);
  }

  public void typeInputRepeatPassword(String text) {
    repeatPasswordInput.sendKeys(text);
  }

  public void clickReCaptcha() {
    reCaptcha.click();
  }

  public void clickRegistrationButton() {
    registrationButton.click();
  }
}
