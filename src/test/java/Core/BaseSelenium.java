package Core;

import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;

import org.junit.jupiter.api.AfterAll;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;
import io.github.bonigarcia.wdm.WebDriverManager;

abstract public class BaseSelenium {
    protected WebDriver driver;

    @Before
    public void setUp(){
        System.out.println("Setup method called");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        System.out.println("Driver initialized: " + (driver != null));
        // настройка 1: загрузка страницы
        // настройка 2: таймаут для взаимодейтсвия с элементами
        driver.manage().window().maximize(); // для открытия обычной версии браузера
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        BaseSeleniumPage.setDriver(driver);

    }

    @AfterAll
    public void tearDown(){
        //делаем чтобы закрыть браузер после теста
        driver.close(); // для заврешения процесса веб-драйвера
        driver.quit(); //закрыли именно сам браузер
    }
}
