package DAO;

import models.Client;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.Collection;
import java.sql.SQLException;

/**
 * Created by zhigan on 27.03.17.
 */
public class ClientDAO {
    public void addClient(Client client) throws SQLException {
        Session session = null;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(client);
        session.getTransaction().commit();
        if (session != null && session.isOpen()) {
            session.close();
        }
    }
    public Client getClient(long id) throws SQLException {
        Session session = null;
        System.out.print("step1\n");
        session = HibernateUtil.getSessionFactory().openSession();
        System.out.print("step2\n");
        Client client = session.load(Client.class, id);
        System.out.print("step3\n");
        if (session != null && session.isOpen()) {
            session.close();
        }
        System.out.print("step4\n");
        return client;
    }
}
