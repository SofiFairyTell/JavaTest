Ошибка org.openqa.selenium.remote.http.ConnectionFailedException: Unable to establish websocket connection указывает на проблему с установлением соединения через WebSocket, что часто связано с конфигурацией Selenium, Chrome или сетевыми ограничениями. Вот несколько шагов, которые могут помочь решить эту проблему:
1. Обновление Selenium и WebDriverManager
- Убедитесь, что у вас установлены последние версии Selenium WebDriver и WebDriverManager. Обновите зависимости в вашем проекте:        
        Maven (pom.xml):
    ```xml
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>4.16.0</version> <!-- или более новая версия -->
    </dependency>
    <dependency>
        <groupId>io.github.bonigarcia</groupId>
        <artifactId>webdrivermanager</artifactId>
        <version>5.6.4</version> <!-- или более новая версия -->
    </dependency>
    ```           
    Gradle (build.gradle):    
    ```groovy
    dependencies {
        implementation 'org.seleniumhq.selenium:selenium-java:4.16.0' // или более новая версия
        implementation 'io.github.bonigarcia:webdrivermanager:5.6.4' // или более новая версия
    }
    ```    
2. Настройка Chrome Options
- Добавьте определенные аргументы в ChromeOptions для решения проблем с WebSocket:
```java
ChromeOptions options = new ChromeOptions();
options.addArguments("--remote-allow-origins=*"); // Это может помочь в некоторых случаях
WebDriverManager.chromedriver().setup();
driver = new ChromeDriver(options);
``` 

3. Проверка версии Chrome и ChromeDriver
- Убедитесь, что версия ChromeDriver совпадает с версией вашего браузера Chrome. Если они не совпадают, обновите либо Chrome, либо ChromeDriver через WebDriverManager.    
4. Проблемы сети
- Проверьте сетевые настройки:    
    - Убедитесь, что нет брандмауэров или прокси, которые блокируют WebSocket соединения.        
    - Проверьте, может ли ваша сеть ограничивать доступ к localhost или к определенным портам.      
5. Проблема с портом
- Порт, на который пытается подключиться Selenium (в данном случае 57122), может быть занят или блокирован. Попробуйте изменить порт или убедитесь, что он свободен:  
```java
ChromeOptions options = new ChromeOptions();
options.addArguments("--remote-debugging-port=9222"); // Или другой свободный порт
WebDriverManager.chromedriver().setup();
driver = new ChromeDriver(options);
```
  6. Обновление WebDriver
- Если вы используете недавно выпущенную версию Chrome, возможно, вам нужно использовать последние экспериментальные сборки ChromeDriver или ждать обновления Selenium для поддержки новых версий Chrome.    
7. Проверка логов
- Проверьте логи ChromeDriver и Selenium на наличие дополнительной информации о причине проблемы.   

Если после этих шагов проблема не решается, возможно, стоит рассмотреть дополнительные настройки или даже обратиться к сообществу Selenium за помощью, так как проблема может быть специфичной для вашей конфигурации или окружения.