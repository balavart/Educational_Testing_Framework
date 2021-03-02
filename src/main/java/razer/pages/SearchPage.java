package razer.pages;

import io.qameta.allure.Step;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

  @FindBy(css = ".products-filter-card-type-2__wrap")
  List<WebElement> searchResultElements;

  public SearchPage(WebDriver driver) {
    PageFactory.initElements(driver, this);
  }

  @Step
  public List<WebElement> getResults() {
    return searchResultElements;
  }
}
