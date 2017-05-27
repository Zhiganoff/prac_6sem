package service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import DAO.impl.PurchaseDAO;
import model.Purchase;

@Service
public class PurchaseService {

    private PurchaseDAO purchaseDAO;

    public void setPurchaseDAO(PurchaseDAO purchaseDAO) {
        this.purchaseDAO = purchaseDAO;
    }

    @Transactional
    public void addPurchase(Purchase p) {
        this.purchaseDAO.addSample(p);
    }

    @Transactional
    public void updatePurchase(Purchase p) {
        this.purchaseDAO.updateSample(p);
    }

    @Transactional
    public List<Purchase> listPurchases() {
        return this.purchaseDAO.listAll();
    }

    @Transactional
    public Purchase getPurchaseById(Long id) {
        return this.purchaseDAO.getById(id);
    }

    @Transactional
    public void removePurchase(Long id) {
        this.purchaseDAO.removeById(id);
    }

}
