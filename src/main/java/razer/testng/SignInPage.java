package razer.testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {

  @FindBy(css = "input[placeholder=E-mail]")
  private WebElement loginInput;

  @FindBy(css = "input[placeholder=Пароль]")
  private WebElement passwordInput;

  public SignInPage(WebDriver driver) {
    PageFactory.initElements(driver, this);
  }

  public void typeInputLogin(String text) {
    loginInput.sendKeys(text);
  }

  public void typeInputPassword(String text) {
    passwordInput.sendKeys(text);
  }
}
