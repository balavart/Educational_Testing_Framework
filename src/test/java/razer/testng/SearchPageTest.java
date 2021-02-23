package razer.testng;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import razer.base.DriverWrapper;

public class SearchPageTest {
  final DriverWrapper driverWrapper = new DriverWrapper();

  @BeforeMethod
  void setUp() {
    driverWrapper.init();
  }

  @AfterMethod
  void tearDown() {
    driverWrapper.close();
  }

  @Test(priority = 1, groups = "Goods_number")
  @Description("Checking the correct number of mice on the page")
  void searchMouseNumber() {
    MainPage mainPage = new MainPage(driverWrapper.getDriver());
    mainPage.search("mouse");

    Allure.addAttachment("Search page", "Mice");

    SearchPage searchPage = new SearchPage(driverWrapper.getDriver());
    List<WebElement> results = searchPage.getResults();
    Assert.assertEquals(18, results.size());
  }
}