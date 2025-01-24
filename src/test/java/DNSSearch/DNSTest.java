package DNSSearch;

import Core.BaseSelenium;
import org.junit.Test;

public class DNSTest extends BaseSelenium {
    @Test
    public void UserSearch(){
      MainPage mainPage = new MainPage().StartSearch();
    }
}
