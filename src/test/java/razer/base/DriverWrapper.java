package razer.base;

import static razer.config.EnvConfig.APP_URL;
import static razer.config.EnvConfig.DRIVER_PATH;
import static razer.config.EnvConfig.DRIVER_TYPE;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverWrapper {

  private WebDriver driver;

  public void init() {
    System.setProperty(DRIVER_TYPE, System.getProperty("user.dir") + DRIVER_PATH);
    driver = new ChromeDriver();
    driver.get(APP_URL);
    driver.manage().deleteAllCookies();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
  }

  public void close() {
    this.driver.quit();
  }

  public WebDriver getDriver() {
    return driver;
  }
}
