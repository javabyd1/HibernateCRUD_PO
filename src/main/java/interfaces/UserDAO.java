package interfaces;

import model.User;

import java.util.List;

/**
 * Created by HP on 2017-11-05.
 */
public interface UserDAO {
    public User insertUser(User u);

    public List<User> getAllUsers();

    public void updateUser(int id, String name, String surname);

    public void removeUser(int id);

    public User findUser(int id);
}
