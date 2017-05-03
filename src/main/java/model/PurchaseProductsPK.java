package model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by zhigan on 30.03.17.
 */
public class PurchaseProductsPK implements Serializable {
    private Long purchaseId;
    private Long productId;

    @Column(name = "purchase_id", nullable = false)
    @Id
    public Long getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Long purchaseId) {
        this.purchaseId = purchaseId;
    }

    @Column(name = "product_id", nullable = false)
    @Id
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PurchaseProductsPK that = (PurchaseProductsPK) o;

        if (purchaseId != null ? !purchaseId.equals(that.purchaseId) : that.purchaseId != null) return false;
        if (productId != null ? !productId.equals(that.productId) : that.productId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = purchaseId != null ? purchaseId.hashCode() : 0;
        result = 31 * result + (productId != null ? productId.hashCode() : 0);
        return result;
    }
}
