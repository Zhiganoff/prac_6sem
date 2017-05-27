package control;

import model.Purchase;

import java.sql.Timestamp;

public class PurchaseBridge {
    private Long id;
    private Timestamp date;
    private String address;
    private String status;
    private Boolean deliveryMethod;
    private Boolean paymentMethod;
    private Long clientId;

    public PurchaseBridge() {}

    public PurchaseBridge(Purchase p) {
        this.id = p.getId();
        this.date = p.getDate();
        this.address = p.getAddress();
        this.status = p.getStatus();
        this.deliveryMethod = p.getDeliveryMethod();
        this.paymentMethod = p.getPaymentMethod();
        this.clientId = p.getClientByClientId().getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getDeliveryMethod() {
        return deliveryMethod;
    }

    public void setDeliveryMethod(Boolean deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }

    public Boolean getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(Boolean paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }
}
