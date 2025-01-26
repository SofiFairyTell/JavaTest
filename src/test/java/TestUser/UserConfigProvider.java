package TestUser;

import com.typesafe.config.Config;
import readConfiguration.ConfigProvider;

/**
 * Класс обертка для доступа к данным
 * @version 1.0
 */

public class UserConfigProvider {
    private static final Config userConfig = ConfigProvider.readUser();

    public static String getUserValue(String key) {
        return userConfig.getString(key);
    }
}
