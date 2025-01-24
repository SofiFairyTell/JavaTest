package readConfiguration;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public interface ConfigProvider {
    Config config = readConfig();
    static Config readConfig()    {

        return ConfigFactory.systemProperties().hasPath("testProfile")
                ?ConfigFactory.load(ConfigFactory.systemProperties().getString("testProfile"))
                :ConfigFactory.load("application.conf");
    }

    String URL = readConfig().getString("url");;
//    String SearhElemet = readConfig().getString("searchTestList.searchInput");
//    String SearchButton = readConfig().getString("searchButton");
    String CaseTest1 = readConfig().getString("searchTestList.case1.find");;
}
