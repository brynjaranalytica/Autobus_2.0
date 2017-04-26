package autoBus;

import java.util.ArrayList;

/**
 * Created by lenovo on 4/24/2017.
 */
public class UsersArchive {
    private ArrayList<User> users;

    public UsersArchive() {
        this.users = new ArrayList<>();
    }

    public void addUser(User user){
        this.users.add(user);
    }

    public User getUser(int index){
        return users.get(index);
    }

    public void removeUser(int index){
        users.remove(index);
    }

    public void removeUser(User user){
        users.remove(user);
    }

    public ArrayList<User> getUsers() {
        return users;
    }
}
