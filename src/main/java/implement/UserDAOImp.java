package implement;

import com.sun.xml.internal.ws.handler.HandlerException;
import interfaces.UserDAO;
import model.User;
import org.hibernate.Session;
import utility.HibernateUtility;

import java.util.List;

/**
 * Created by HP on 2017-11-05.
 */
public class UserDAOImp implements UserDAO {

    Session session = HibernateUtility.getHibernateSession();

    public User insertUser(User u) {
        try {
            System.out.println(u.getName()+" "+u.getSurname());
            session.beginTransaction();
            session.save(u);
            session.getTransaction().commit();
        }catch (HandlerException e){
            if (session.getTransaction()!=null){
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        }
        return u;
    }

    public List<User> getAllUsers() {
        return null;
    }

    public void updateUser(int id, String name, String surname) {

    }

    public void removeUser(int id) {

    }

    public User findUser(int id) {
        return null;
    }
}
