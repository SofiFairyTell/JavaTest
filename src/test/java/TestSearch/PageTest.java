package TestSearch;

import Core.BaseSelenium;
import org.junit.Test;

public class PageTest extends BaseSelenium {
  //  @Test
    public void UserSearch(){
      MainPage mainPage = new MainPage().StartSearch();
    }
}
