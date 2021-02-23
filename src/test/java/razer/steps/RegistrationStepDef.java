package razer.steps;

import static razer.config.UserConfig.NEW_EMAIL;
import static razer.config.UserConfig.NEW_NAME;
import static razer.config.UserConfig.NEW_PASSWORD;
import static razer.config.UserConfig.NEW_PHONE_NUMBER;
import static razer.config.UserConfig.NEW_SURNAME;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import razer.base.DriverWrapper;
import razer.testng.AccountPage;
import razer.testng.MainPage;
import razer.testng.RegistrationPage;

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

  @Then("Open registration page")
  public void openRegistrationPage() {
    MainPage page = new MainPage(wrapper.getDriver());
    page.clickUserButton();
    page.clickCreateAccountButton();
  }

  @Then("Input name")
  public void inputName() {
    RegistrationPage page = new RegistrationPage(wrapper.getDriver());
    page.typeInputNewName(NEW_NAME);
  }

  @Then("Input surname")
  public void inputSurname() {
    RegistrationPage page = new RegistrationPage(wrapper.getDriver());
    page.typeInputSurname(NEW_SURNAME);
  }

  @Then("Input email")
  public void inputEmail() {
    RegistrationPage page = new RegistrationPage(wrapper.getDriver());
    page.typeInputEmail(NEW_EMAIL);
  }

  @Then("Input phone number")
  public void inputPhoneNumber() {
    RegistrationPage page = new RegistrationPage(wrapper.getDriver());
    page.typeInputPhoneNumber(NEW_PHONE_NUMBER);
  }

  @Then("Input new password")
  public void inputNewPassword() {
    RegistrationPage page = new RegistrationPage(wrapper.getDriver());
    page.typeInputNewPasswordInput(NEW_PASSWORD);
  }

  @Then("Input new password repeatedly")
  public void inputNewPasswordRepeatedly() {
    RegistrationPage page = new RegistrationPage(wrapper.getDriver());
    page.typeInputRepeatPassword(NEW_PASSWORD);
  }

  @Then("Click ReCaptcha")
  public void clickReCaptcha() {
    RegistrationPage page = new RegistrationPage(wrapper.getDriver());
    page.clickReCaptcha();
  }

  @Then("Click registration button")
  public void clickRegistrationButton() {
    RegistrationPage page = new RegistrationPage(wrapper.getDriver());
    page.clickRegistrationButton();
  }

  @Then("Check name field")
  public void checkNameField() {
    AccountPage page = new AccountPage(wrapper.getDriver());
    String actual = page.getAccountUserName();
    String expected = NEW_NAME;
    Assert.assertEquals(actual, expected);
  }
}
