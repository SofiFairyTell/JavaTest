package TestUser;

import java.util.*;

import static java.lang.Integer.parseInt;

public class User {
    private int id;
    private String name;
    private int age;
    private String gender;

    private static int countId = 0;
    // Для хранения всех пользователей
    private static Map<Integer, User> allUsers = new HashMap<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age &&
                Objects.equals(name, user.name) &&
                gender == user.gender;
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, age, gender);
    }

    private boolean hasUser(){
        for (User user : allUsers.values()){
            if (user.equals(this) && user.hashCode() == this.hashCode()){
                return true;
            }
        }
        return false;
    }

    public User(String name, Integer age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;

        if (!hasUser()){
            countId++;
            this.id = countId;
            allUsers.put(id, this);
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }

    //Формировать список всех пользователей, и с разделением по полу
    public static List<User> getAllUsers(){
        return new ArrayList<>(allUsers.values());
    }

    public static List<User> getAllUsers(String gender){
        List<User> listAllUsers = new ArrayList<>();
        for (User user : allUsers.values()){
            if (user.gender == gender){
                listAllUsers.add(user);
            }
        }
        return listAllUsers;
    }
// Возвращать количество пользователей в общем списке, и посчитать количество по признаку пола пользователя
public static int getHowManyUsers(){
    return allUsers.size();
}

    public static int getHowManyUsers(String gender){
        return getAllUsers(gender).size();
    }
}
