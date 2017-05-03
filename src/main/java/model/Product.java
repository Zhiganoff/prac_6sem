package model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by zhigan on 30.03.17.
 */
@Entity
public class Product {
    private Long id;
    private String name;
    private Integer cost;
    private Integer num;
    private String size;
    private String properties;
    private ProductType productTypeByProducttypeId;
    private Producer producerByProducerId;
    private Collection<PurchaseProducts> purchaseProductsByProductId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long productId) {
        this.id = productId;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 63)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "cost", nullable = false)
    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    @Basic
    @Column(name = "num", nullable = false)
    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Basic
    @Column(name = "size", nullable = false, length = 15)
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Basic
    @Column(name = "properties", nullable = false, length = -1)
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

        if (id != null ? !id.equals(product.id) : product.id != null) return false;
        if (name != null ? !name.equals(product.name) : product.name != null) return false;
        if (cost != null ? !cost.equals(product.cost) : product.cost != null) return false;
        if (num != null ? !num.equals(product.num) : product.num != null) return false;
        if (size != null ? !size.equals(product.size) : product.size != null) return false;
        if (properties != null ? !properties.equals(product.properties) : product.properties != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (cost != null ? cost.hashCode() : 0);
        result = 31 * result + (num != null ? num.hashCode() : 0);
        result = 31 * result + (size != null ? size.hashCode() : 0);
        result = 31 * result + (properties != null ? properties.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "producttype_id", referencedColumnName = "id", nullable = false)
    public ProductType getProductTypeByProducttypeId() {
        return productTypeByProducttypeId;
    }

    public void setProductTypeByProducttypeId(ProductType productTypeByProducttypeId) {
        this.productTypeByProducttypeId = productTypeByProducttypeId;
    }

    @ManyToOne
    @JoinColumn(name = "producer_id", referencedColumnName = "id", nullable = false)
    public Producer getProducerByProducerId() {
        return producerByProducerId;
    }

    public void setProducerByProducerId(Producer producerByProducerId) {
        this.producerByProducerId = producerByProducerId;
    }

    @OneToMany(mappedBy = "productByProductId")
    public Collection<PurchaseProducts> getPurchaseProductsByProductId() {
        return purchaseProductsByProductId;
    }

    public void setPurchaseProductsByProductId(Collection<PurchaseProducts> purchaseProductsByProductId) {
        this.purchaseProductsByProductId = purchaseProductsByProductId;
    }
}
