package util;

/**
 * Created by zhigan on 27.03.17.
 */

import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;

public class HibernateUtil {
    private static final SessionFactory sessionFactory;
    static {
        System.out.println("static\n");
        sessionFactory = new Configuration().configure().buildSessionFactory();
        System.out.println("after static\n");
    }

    public static SessionFactory getSessionFactory() {
        System.out.println("getsessionFactory\n");
        return sessionFactory;
    }
}