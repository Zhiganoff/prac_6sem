package service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import DAO.impl.ProductTypeDAO;
import model.ProductType;

@Service
public class ProductTypeService {

    private ProductTypeDAO productTypeDAO;

    public void setProductTypeDAO(ProductTypeDAO productTypeDAO) {
        this.productTypeDAO = productTypeDAO;
    }

    @Transactional
    public void addProductType(ProductType p) {
        this.productTypeDAO.addSample(p);
    }

    @Transactional
    public void updateProductType(ProductType p) {
        this.productTypeDAO.updateSample(p);
    }

    @Transactional
    public List<ProductType> listProductTypes() {
        return this.productTypeDAO.listAll();
    }

    @Transactional
    public ProductType getProductTypeById(Long id) {
        return this.productTypeDAO.getById(id);
    }

    @Transactional
    public void removeProductType(Long id) {
        this.productTypeDAO.removeById(id);
    }

}
