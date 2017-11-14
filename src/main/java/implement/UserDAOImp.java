package implement;

import com.sun.xml.internal.ws.handler.HandlerException;
import interfaces.UserDAO;
import model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.annotations.SourceType;
import utility.HibernateUtility;

import java.util.Iterator;
import java.util.List;

/**
 * Created by HP on 2017-11-05.
 */
public class UserDAOImp implements UserDAO {

    Session session = HibernateUtility.getHibernateSession();

    public User insertUser(User u) {
        try {
            System.out.println(u.getName() + " " + u.getSurname());
            session.beginTransaction();
            session.save(u);
            session.getTransaction().commit();
        } catch (HandlerException e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        }


        return u;
    }

    public List<User> getAllUsers() {


        List<User> users = null;

        try {
            session.beginTransaction();
            users = session.createQuery("FROM User").list();
            for (Iterator<User> iterator = users.iterator();
                 iterator.hasNext(); ) {
                User user = (User) iterator.next();
                System.out.print(user.getId() + ". ");
                System.out.print(" " + user.getName() + " ");
                System.out.print(user.getSurname() + "\n");

            }
            session.getTransaction().commit();
        } catch (HibernateException e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();

        }

        return users;


    }

    public void updateUser(int id, String name, String surname) {
        try {
            session.beginTransaction();
            User user = session.get(User.class, id);

            user.setName(name);
            user.setSurname(surname);
            session.update(user);
            session.getTransaction().commit();

        } catch (HibernateException e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();

        }
    }

    public void removeUser(int id) {


        try {
            session.beginTransaction();
            User user = session.get(User.class, id);
            if (user != null){
            session.delete(user);
            }else {
                System.out.println("Nie ma osoby o takim Id.");
            }
            session.getTransaction().commit();

        } catch (HibernateException e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();

        }

    }

    public User findUser(int id) {

        User user = null;
        try {
            session.beginTransaction();
            user = session.get(User.class, id);
            System.out.println(user.getId() + ". " + user.getName() + " " + user.getSurname());
            session.getTransaction().commit();
        } catch (HibernateException e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();


        }
        return user;
    }
}
