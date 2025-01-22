package DNSSearch;

import Core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BaseSeleniumPage {
    @FindBy(xpath = "//select[@id='products-orderby']");
    private WebElement searchField;

    @FindBy(xpath = "//select[@id='products-orderby']");
}
