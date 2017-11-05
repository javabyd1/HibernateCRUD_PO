import implement.UserDAOImp;
import model.User;

/**
 * Created by HP on 2017-11-05.
 */
public class Main {

    public static void main(String[] args) {
        UserDAOImp userDAOImp = new UserDAOImp();
        User user = new User();
        user.setName("Jan");
        user.setSurname("Kowalski");

        User user1 = new User();
        user1.setName("Andrzej");
        user1.setSurname("Kowalski");

        userDAOImp.insertUser(user);
        userDAOImp.insertUser(user1);
    }
}
