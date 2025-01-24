package DNSSearch;

import Core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import readConfiguration.ConfigProvider;

public class MainPage extends BaseSeleniumPage {

  @FindBy(xpath = "/html/body/div[1]/div[5]/div/aside/div/div[2]/form/div/input")
    private WebElement serchElem;

    @FindBy(xpath = "/html/body/div[1]/div[5]/div/aside/div/div[2]/form/div/button")
    private WebElement serchButton;;

  public MainPage() {
    if (driver != null) {
      driver.get(ConfigProvider.URL);
    } else {
      System.out.println("Driver is not initialized!");
      }

    PageFactory.initElements(driver, this);
  }

  public MainPage StartSearch(){
    serchElem.sendKeys(ConfigProvider.CaseTest1);
    serchButton.click();
    return this;
  }

}
