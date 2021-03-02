package razer.steps;

import static razer.config.UserConfig.NEW_EMAIL;
import static razer.config.UserConfig.NEW_NAME;
import static razer.config.UserConfig.NEW_PASSWORD;
import static razer.config.UserConfig.NEW_PHONE_NUMBER;
import static razer.config.UserConfig.NEW_SURNAME;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import razer.base.DriverWrapper;
import razer.pages.AccountPage;
import razer.pages.MainPage;
import razer.pages.RegistrationPage;

public class RegistrationStepDef {

  private final DriverWrapper wrapper;

  public RegistrationStepDef() {
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

  @When("Open registration page")
  public void openRegistrationPage() {
    MainPage page = new MainPage(wrapper.getDriver());
    page.clickUserButton();
    page.clickCreateAccountButton();
  }

  @When("Input name")
  public void inputName() {
    RegistrationPage page = new RegistrationPage(wrapper.getDriver());
    page.typeInputNewName(NEW_NAME);
  }

  @When("Input surname")
  public void inputSurname() {
    RegistrationPage page = new RegistrationPage(wrapper.getDriver());
    page.typeInputSurname(NEW_SURNAME);
  }

  @When("Input email")
  public void inputEmail() {
    RegistrationPage page = new RegistrationPage(wrapper.getDriver());
    page.typeInputEmail(NEW_EMAIL);
  }

  @When("Input phone number")
  public void inputPhoneNumber() {
    RegistrationPage page = new RegistrationPage(wrapper.getDriver());
    page.typeInputPhoneNumber(NEW_PHONE_NUMBER);
  }

  @When("Input new password")
  public void inputNewPassword() {
    RegistrationPage page = new RegistrationPage(wrapper.getDriver());
    page.typeInputNewPasswordInput(NEW_PASSWORD);
  }

  @When("Input new password repeatedly")
  public void inputNewPasswordRepeatedly() {
    RegistrationPage page = new RegistrationPage(wrapper.getDriver());
    page.typeInputRepeatPassword(NEW_PASSWORD);
  }

  @When("Click ReCaptcha")
  public void clickReCaptcha() {
    RegistrationPage page = new RegistrationPage(wrapper.getDriver());
    page.clickReCaptcha();
  }

  @When("Click registration button")
  public void clickRegistrationButton() {
    RegistrationPage page = new RegistrationPage(wrapper.getDriver());
    page.clickRegistrationButton();
  }

  @Then("Check name field")
  public void checkNameField() {
    AccountPage page = new AccountPage(wrapper.getDriver());
    String actual = page.getAccountUserName();
    Assert.assertEquals(actual, NEW_NAME, "User failed to register");
  }
}
