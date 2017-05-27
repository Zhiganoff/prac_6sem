package model;

import javax.persistence.*;

/**
 * Created by zhigan on 30.03.17.
 */
@Entity
@IdClass(PurchaseProductsPK.class)
public class PurchaseProducts{
    private Long purchaseId;
    private Long productId;
    private Integer num;
    private Purchase purchaseByPurchaseId;
    private Product productByProductId;

    @Id
    @Column(name = "purchase_id", nullable = false)
    public Long getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Long purchaseId) {
        this.purchaseId = purchaseId;
    }

    @Id
    @Column(name = "product_id", nullable = false)
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "num", nullable = false)
    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PurchaseProducts that = (PurchaseProducts) o;

        if (purchaseId != null ? !purchaseId.equals(that.purchaseId) : that.purchaseId != null) return false;
        if (productId != null ? !productId.equals(that.productId) : that.productId != null) return false;
        if (num != null ? !num.equals(that.num) : that.num != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = purchaseId != null ? purchaseId.hashCode() : 0;
        result = 31 * result + (productId != null ? productId.hashCode() : 0);
        result = 31 * result + (num != null ? num.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "purchase_id", referencedColumnName = "id", nullable = false, insertable=false, updatable=false)
    public Purchase getPurchaseByPurchaseId() {
        return purchaseByPurchaseId;
    }

    public void setPurchaseByPurchaseId(Purchase purchaseByPurchaseId) {
        this.purchaseByPurchaseId = purchaseByPurchaseId;
    }

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false, insertable=false, updatable=false)
    public Product getProductByProductId() {
        return productByProductId;
    }

    public void setProductByProductId(Product productByProductId) {
        this.productByProductId = productByProductId;
    }
}
