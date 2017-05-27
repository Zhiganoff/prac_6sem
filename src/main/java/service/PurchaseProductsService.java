package service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import DAO.impl.PurchaseProductsDAO;
import model.PurchaseProducts;

@Service
public class PurchaseProductsService {

    private PurchaseProductsDAO purchaseProductsDAO;

    public void setPurchaseProductsDAO(PurchaseProductsDAO purchaseProductsDAO) {
        this.purchaseProductsDAO = purchaseProductsDAO;
    }

    @Transactional
    public void addPurchaseProducts(PurchaseProducts p) {
        this.purchaseProductsDAO.addSample(p);
    }

    @Transactional
    public void updatePurchaseProducts(PurchaseProducts p) {
        this.purchaseProductsDAO.updateSample(p);
    }

    @Transactional
    public List<PurchaseProducts> listPurchaseProducts() {
        return this.purchaseProductsDAO.listAll();
    }

    @Transactional
    public PurchaseProducts getPurchaseProductsByIds(Long purchaseId, Long productId) {
        return this.purchaseProductsDAO.getByIds(purchaseId, productId);
    }

    @Transactional
    public void removePurchaseProducts(Long id) {
        this.purchaseProductsDAO.removeById(id);
    }

}
