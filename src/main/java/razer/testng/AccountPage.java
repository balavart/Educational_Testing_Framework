package razer.testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {

  @FindBy(xpath = "//*[text()='Данные покупателя']")
  private WebElement accountTitle;

  @FindBy(xpath = "//span[text()='Имя']/following::input[1]")
  private WebElement accountUserName;

  @FindBy(xpath = "//span[text()='Фамилия']/following::input[1]")
  private WebElement accountUserSurname;

  public AccountPage(WebDriver driver) {
    PageFactory.initElements(driver, this);
  }

  public boolean accountTitleIsVisible() {
    return accountTitle.isDisplayed();
  }

  public String getAccountUserName() {
    return accountUserName.toString();
  }

  public String getAccountUserSurname() {
    return accountUserSurname.toString();
  }
}
