package models;

import java.util.Collection;

/**
 * Created by zhigan on 28.03.17.
 */
public class Product {
    private Long productId;
    private Integer producttypeId;
    private Long producerId;
    private String name;
    private Integer cost;
    private Integer num;
    private String size;
    private String properties;
    private ProductType productTypeByProducttypeId;
    private Producer producerByProducerId;
    private Collection<PurchaseProducts> purchaseProductsByProductId;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getProducttypeId() {
        return producttypeId;
    }

    public void setProducttypeId(Integer producttypeId) {
        this.producttypeId = producttypeId;
    }

    public Long getProducerId() {
        return producerId;
    }

    public void setProducerId(Long producerId) {
        this.producerId = producerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getProperties() {
        return properties;
    }

    public void setProperties(String properties) {
        this.properties = properties;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (productId != null ? !productId.equals(product.productId) : product.productId != null) return false;
        if (producttypeId != null ? !producttypeId.equals(product.producttypeId) : product.producttypeId != null)
            return false;
        if (producerId != null ? !producerId.equals(product.producerId) : product.producerId != null) return false;
        if (name != null ? !name.equals(product.name) : product.name != null) return false;
        if (cost != null ? !cost.equals(product.cost) : product.cost != null) return false;
        if (num != null ? !num.equals(product.num) : product.num != null) return false;
        if (size != null ? !size.equals(product.size) : product.size != null) return false;
        if (properties != null ? !properties.equals(product.properties) : product.properties != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = productId != null ? productId.hashCode() : 0;
        result = 31 * result + (producttypeId != null ? producttypeId.hashCode() : 0);
        result = 31 * result + (producerId != null ? producerId.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (cost != null ? cost.hashCode() : 0);
        result = 31 * result + (num != null ? num.hashCode() : 0);
        result = 31 * result + (size != null ? size.hashCode() : 0);
        result = 31 * result + (properties != null ? properties.hashCode() : 0);
        return result;
    }

    public ProductType getProductTypeByProducttypeId() {
        return productTypeByProducttypeId;
    }

    public void setProductTypeByProducttypeId(ProductType productTypeByProducttypeId) {
        this.productTypeByProducttypeId = productTypeByProducttypeId;
    }

    public Producer getProducerByProducerId() {
        return producerByProducerId;
    }

    public void setProducerByProducerId(Producer producerByProducerId) {
        this.producerByProducerId = producerByProducerId;
    }

    public Collection<PurchaseProducts> getPurchaseProductsByProductId() {
        return purchaseProductsByProductId;
    }

    public void setPurchaseProductsByProductId(Collection<PurchaseProducts> purchaseProductsByProductId) {
        this.purchaseProductsByProductId = purchaseProductsByProductId;
    }
}
