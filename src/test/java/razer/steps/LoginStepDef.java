package razer.steps;

import static razer.config.UserConfig.USER_LOGIN;
import static razer.config.UserConfig.USER_PASSWORD;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import razer.base.DriverWrapper;
import razer.pages.AccountPage;
import razer.pages.MainPage;
import razer.pages.SignInPage;

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

  @When("Click User button")
  public void clickButton() {
    MainPage page = new MainPage(wrapper.getDriver());
    page.clickUserButton();
  }

  @When("Input login")
  public void inputLogin() {
    SignInPage page = new SignInPage(wrapper.getDriver());
    page.typeInputLogin(USER_LOGIN);
  }

  @When("Input password")
  public void inputPassword() {
    SignInPage page = new SignInPage(wrapper.getDriver());
    page.typeInputPassword(USER_PASSWORD);
  }

  @When("Click Submit button")
  public void clickSubmitButton() {
    MainPage page = new MainPage(wrapper.getDriver());
    page.clickSubmitButton();
  }

  @When("Enter personal account")
  public void enterPersonalAccount() {
    MainPage page = new MainPage(wrapper.getDriver());
    page.clickUserButton();
    page.clickAccountButton();
  }

  @Then("Content with Данные покупателя visible")
  public void contentWithVisible() {
    AccountPage page = new AccountPage(wrapper.getDriver());
    Assert.assertTrue(page.accountTitleIsVisible(), "User failed to login");
  }
}
