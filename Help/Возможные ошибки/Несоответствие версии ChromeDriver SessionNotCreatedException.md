Ошибка org.openqa.selenium.SessionNotCreatedException с сообщением о том, что текущая версия ChromeDriver поддерживает только Chrome версии 114, указывает на несоответствие между версией ChromeDriver и установленной версией браузера Google Chrome на вашем компьютере. Вот как это можно решить:
1. Проверка версии Chrome:
        - Откройте Google Chrome и перейдите в chrome://version/ в адресной строке, чтобы проверить текущую версию браузера.        
2. Обновление Chrome или ChromeDriver:    
    - Обновление Chrome: Если ваша версия Chrome не соответствует версии 114, вы можете обновить браузер до последней версии. Это самый предпочтительный вариант, так как обычно обновление Chrome происходит автоматически.        
    - Обновление ChromeDriver:        
        - Если обновление Chrome не является возможным или желательным, вам нужно скачать версию ChromeDriver, совместимую с вашей текущей версией Chrome. Вы можете сделать это, посетив страницу загрузки ChromeDriver и выбрав соответствующую версию.
            
3. Использование WebDriverManager:    
    - Вы уже используете WebDriverManager, который должен автоматически скачать и установить правильную версию ChromeDriver. Однако, возможно, WebDriverManager не обновился до последней версии, которая поддерживает новые версии Chrome. Убедитесь, что используете последнюю версию WebDriverManager:        
        - Обновите зависимость WebDriverManager в вашем проекте до последней версии через Maven или Gradle. Ниже приведен пример для Maven:            
            ```xml
            <dependency>
                <groupId>io.github.bonigarcia</groupId>
                <artifactId>webdrivermanager</artifactId>
                <version>5.6.4</version> <!-- или более новая версия -->
            </dependency>
            ```
            
    - После обновления, повторите настройку драйвера в вашем коде:               
        ```java
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        ```
        
4. Очистка кэша WebDriverManager:    
    - Иногда старые версии драйверов могут оставаться в кэше. Удалите файл resolution.properties из кэша WebDriverManager (обычно находится в ~/.cache/selenium), чтобы заставить WebDriverManager загрузить новую версию драйвера.        
5. Проверка совместимости:    
    - Если проблема сохраняется, проверьте текущую версию ChromeDriver, которую WebDriverManager пытается использовать. Возможно, вам нужно явно указать версию браузера для WebDriverManager, если автоматическое определение не работает:        
        ```java
        WebDriverManager.chromedriver().browserVersion("Ваша_версия_Chrome").setup();
        ```
