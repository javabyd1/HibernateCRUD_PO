import implement.UserDAOImp;
import model.User;
import utility.HibernateUtility;

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
        user1.setSurname("Nowak");

        User user2 = new User();
        user2.setName("Helena");
        user2.setSurname("Kwiat");

        userDAOImp.insertUser(user);
        userDAOImp.insertUser(user1);
        userDAOImp.insertUser(user2);
        userDAOImp.findUser(3);
        userDAOImp.updateUser(2,"Zenek","Pereszczako");
        userDAOImp.findUser(2);
        userDAOImp.removeUser(1);
        userDAOImp.getAllUsers();

        HibernateUtility.closeSession();
    }
}
