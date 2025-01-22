package Core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

abstract public class BaseSelenium {
    protected WebDriver driver;
    @Before
    public  void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        // настройка 1: загрузка страницы
        // настройка 2: таймаут для взаимодейтсвия с элементами
        driver.manage().window().maximize(); // для открытия обычной версии браузера
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        BaseSeleniumPage.setDriver(driver);

    }

    @After
    public void tearDown(){
        //делаем чтобы закрыть браузер после теста
        driver.close(); // для заврешения процесса веб-драйвера
        driver.quit(); //закрыли именно сам браузер
    }
}
