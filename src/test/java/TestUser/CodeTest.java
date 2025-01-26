package TestUser;

import Core.BaseSelenium;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static readConfiguration.ConfigProvider.readUser;

public class CodeTest extends BaseSelenium {
    @Test
    public void getAllUsers() {
            String userName = UserConfigProvider.getUserValue("usertestList.User1.name");;
            Integer userAge = Integer.valueOf(UserConfigProvider.getUserValue("usertestList.User1.age"));;
            String userGender = UserConfigProvider.getUserValue("usertestList.User1.gender");;
      User user = new User( userName, userAge,  userGender);

      List<User> expected = User.getAllUsers();

     List<User> actual = new ArrayList<>();
     actual.add(new User("Ivan", 20, "male"));

     Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAllUsers_MALE() {

        User user1 = new User(  UserConfigProvider.getUserValue("usertestList.User1.name"),
                                Integer.valueOf(UserConfigProvider.getUserValue("usertestList.User1.age")),
                                UserConfigProvider.getUserValue("usertestList.User1.gender"));

        User user2 = new User(  UserConfigProvider.getUserValue("usertestList.User2.name"),
                Integer.valueOf(UserConfigProvider.getUserValue("usertestList.User2.age")),
                UserConfigProvider.getUserValue("usertestList.User2.gender"));

        List<User> expected = User.getAllUsers("male");

        List<User> actual = new ArrayList<>();
        actual.add(user2);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getHowManyUsers() {
        User user1 = new User(  UserConfigProvider.getUserValue("usertestList.User1.name"),
                Integer.valueOf(UserConfigProvider.getUserValue("usertestList.User1.age")),
                UserConfigProvider.getUserValue("usertestList.User1.gender"));

        User user2 = new User(  UserConfigProvider.getUserValue("usertestList.User2.name"),
                Integer.valueOf(UserConfigProvider.getUserValue("usertestList.User2.age")),
                UserConfigProvider.getUserValue("usertestList.User2.gender"));

        int expected = User.getHowManyUsers();

        int actual = 2;

        Assert.assertEquals(expected, actual);
    }
}
