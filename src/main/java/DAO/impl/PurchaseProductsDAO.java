package DAO.impl;

import DAO.AbstractDAO;
import model.Purchase;
import model.PurchaseProducts;
import model.PurchaseProductsPK;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public class PurchaseProductsDAO extends AbstractDAO<PurchaseProducts> {
    public PurchaseProducts getByIds(Long purchaseId, Long productId) {
        PurchaseProductsPK ppPK = new PurchaseProductsPK();
        ppPK.setPurchaseId(purchaseId);
        ppPK.setProductId(productId);

        Session session = this.sessionFactory.getCurrentSession();
        return (PurchaseProducts) session.load(PurchaseProducts.class, ppPK);
    }
}
