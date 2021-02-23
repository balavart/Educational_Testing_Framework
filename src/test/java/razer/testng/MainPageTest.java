package razer.testng;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import razer.base.DriverWrapper;

public class MainPageTest {

  final DriverWrapper driverWrapper = new DriverWrapper();
  final WebDriver driver = driverWrapper.getDriver();

  @BeforeMethod
  void setUp() {
    driverWrapper.init();
  }

  @AfterMethod
  void tearDown() {
    driverWrapper.close();
  }

  @Test(priority = 1, groups = "Text")
  @Description("Checking the page title for correctness")
  void checkTitleString() {
    MainPage mainPage = new MainPage(driver);
    String actual = mainPage.getTitle();
    String expected = "Официальный сайт Razer в России";
    Assert.assertEquals(actual, expected, "Title is not matched");
  }

  @Test(priority = 2, groups = "Images")
  @Description("Checking the presence of the logo")
  void checkPageLogo() {
    MainPage mainPage = new MainPage(driverWrapper.getDriver());
    Assert.assertTrue(mainPage.isLogoDisplayed());
  }

  @Test(priority = 3, groups = "Triggers")
  @Description("Checking the functionality of the support chat window")
  void requestOnlineSupport() {
    MainPage mainPage = new MainPage(driverWrapper.getDriver());
    mainPage.openSupportChat();
    mainPage.typeSupportChat("I have a question!");

    Allure.addAttachment("Open support chat window", "Written appeal");

    mainPage.closeSupportChat();
    Assert.assertFalse(mainPage.isSupportChatDisplayed(), "Chat Support still displayed");
  }

}
