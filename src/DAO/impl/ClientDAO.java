package DAO.impl;

import DAO.AbstractDAO;
import model.Client;
import model.Purchase;
import util.HibernateUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class ClientDAO extends AbstractDAO<Client> {
    public List<Purchase> getPurchasesByClientId(Long id) {
        List<Purchase> res;
        EntityManager em = HibernateUtil.getEm();
        res =em.createQuery("select c from " + Purchase.class.getSimpleName() +
                " c where c.id = " + id, Purchase.class).getResultList();
        em.close();
        return res;
    }
}
