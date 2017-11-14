package utility;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by HP on 2017-11-05.
 */
public class HibernateUtility {

    private final static SessionFactory sf = new Configuration().configure().buildSessionFactory();

    private static Session session = sf.openSession();

    private HibernateUtility() {
    }

    public static Session getHibernateSession() {
        if (session == null) {
            session = (Session) new HibernateUtility();
        }
        return session;
    }

    public static void closeSession() throws HibernateException {
        sf.close();
    }
}
