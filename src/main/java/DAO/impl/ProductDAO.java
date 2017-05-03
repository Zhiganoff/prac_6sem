package DAO.impl;

import DAO.AbstractDAO;
import model.Producer;
import model.Product;
import model.ProductType;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Join;
import javax.persistence.metamodel.Metamodel;
import javax.persistence.metamodel.EntityType;

public class ProductDAO extends AbstractDAO<Product> {
//    public String getProductTypeNameByProductId(Long productId) {
//        return getById(productId).getProductTypeByProducttypeId().getName();
//    }
//    public String getProducerNameByProductId(Long productId) {
//        String res = "tmp_res";
//        EntityManager em = HibernateUtil.getEm();
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery<Product> query = cb.createQuery(Product.class);
//        Root<Product> product = query.from(Product.class);
//
//        Metamodel m = em.getMetamodel();
//        EntityType<Product> productMetaModel = m.entity(Product.class);
//
//        System.out.println("name = " + productMetaModel.getName());
//
//        Join<Product, Producer> producer =
//                product.join(productMetaModel.getSingularAttribute("", Producer.class));
//        Join<Pet, Owner> owner = pet.join(petMetaModel.getSet("owners", Owner.class));
//        query.where(cb.equal(producer.get("id"), productId));
//
//        res = em.createQuery(query).getSingleResult().getName();

//        Product product = getById(productId);
//        String res = product.getProducerByProducerId().getName();
////        em.close();
//        return res;
//    }
}
