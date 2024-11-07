package Bank;

import java.util.ArrayList;
import java.util.List;

public class BankSingleton {
    private static BankSingleton instance;
    private List<User> users;

    private BankSingleton() {
        users = new ArrayList<>();
    }

    public static BankSingleton getInstance() {
        if(instance == null) {
            instance = new BankSingleton();
        }
        return instance;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public User createUser(String username, String password) {
        for (User user : users) {
            if (username.equals(user.getUsername())) {
                throw new IllegalArgumentException("Username is already taken");
            }
        }
        User newUser = new User(username, password);
        users.add(newUser);
        return newUser;
    }

    public User authenticate(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
}
