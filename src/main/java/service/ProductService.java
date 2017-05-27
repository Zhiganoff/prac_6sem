package service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import DAO.impl.ProductDAO;
import model.Product;

@Service
public class ProductService {

    private ProductDAO productDAO;

    public void setProductDAO(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Transactional
    public void addProduct(Product p) {
        this.productDAO.addSample(p);
    }

    @Transactional
    public void updateProduct(Product p) {
        this.productDAO.updateSample(p);
    }

    @Transactional
    public List<Product> listProducts() {
        return this.productDAO.listAll();
    }

    @Transactional
    public Product getProductById(Long id) {
        return this.productDAO.getById(id);
    }

    @Transactional
    public void removeProduct(Long id) {
        this.productDAO.removeById(id);
    }

}
