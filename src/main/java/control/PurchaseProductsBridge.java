package control;

import model.PurchaseProducts;

public class PurchaseProductsBridge {
    private Long purchaseId;
    private Long productId;
    private Integer num;

    public PurchaseProductsBridge() {}

    public PurchaseProductsBridge(PurchaseProducts pp) {
        this.num = pp.getNum();
        this.purchaseId = pp.getPurchaseId();
        this.productId = pp.getProductId();
    }

    public Long getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Long purchaseId) {
        this.purchaseId = purchaseId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
