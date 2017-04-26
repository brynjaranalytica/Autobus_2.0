package autoBus;

/**
 * Created by lenovo on 4/24/2017.
 */
public class User {
    private final String username;
    private final String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof User))
            return false;
        User user = (User) obj;

        return user.getPassword().equals(password) && user.getUsername().equals(username);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
