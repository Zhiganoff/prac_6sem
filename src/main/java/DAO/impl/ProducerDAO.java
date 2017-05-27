package DAO.impl;

import DAO.AbstractDAO;
import model.Producer;
import model.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class ProducerDAO extends AbstractDAO<Producer> {
//    public List<Product> getProductsByProducerId(Long producerId) {
//        List<Product> res;
//        EntityManager em = HibernateUtil.getEm();
//        res = em.createQuery("select c from " + Product.class.getSimpleName() +
//                             " c where c.id = " + producerId, Product.class).getResultList();
//        return res;
//    }
}