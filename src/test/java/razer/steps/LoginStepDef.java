package razer.steps;

import static razer.config.UserConfig.USER_LOGIN;
import static razer.config.UserConfig.USER_PASSWORD;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import razer.base.DriverWrapper;
import razer.testng.AccountPage;
import razer.testng.MainPage;
import razer.testng.SignInPage;

public class LoginStepDef {

  private final DriverWrapper wrapper;

  public LoginStepDef() {
    wrapper = new DriverWrapper();
  }

  @Before
  public void setUp() {
    wrapper.init();
  }

  @After
  public void tearDown() {
    wrapper.close();
  }

  @Then("Click User button")
  public void clickButton() {
    MainPage page = new MainPage(wrapper.getDriver());
    page.clickUserButton();
  }

  @Then("Input login")
  public void inputLogin() {
    SignInPage page = new SignInPage(wrapper.getDriver());
    page.typeInputLogin(USER_LOGIN);
  }

  @Then("Input password")
  public void inputPassword() {
    SignInPage page = new SignInPage(wrapper.getDriver());
    page.typeInputPassword(USER_PASSWORD);
  }

  @Then("Click Submit button")
  public void clickSubmitButton() {
    MainPage page = new MainPage(wrapper.getDriver());
    page.clickSubmitButton();
  }

  @Then("Enter personal account")
  public void enterPersonalAccount() {
    MainPage page = new MainPage(wrapper.getDriver());
    page.clickUserButton();
    page.clickAccountButton();
  }

  @Then("Content with Данные покупателя visible")
  public void contentWithVisible() {
    AccountPage page = new AccountPage(wrapper.getDriver());
    Assert.assertTrue(page.accountTitleIsVisible());
  }
}
