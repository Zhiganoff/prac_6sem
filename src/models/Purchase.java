package models;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by zhigan on 28.03.17.
 */
public class Purchase {
    private Long id;
    private Long clientId;
    private Timestamp date;
    private String address;
    private String status;
    private byte[] deliveryMethod;
    private byte[] paymentMethod;
    private Client clientByClientId;
    private Collection<PurchaseProducts> purchaseProductsById;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
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

    public byte[] getDeliveryMethod() {
        return deliveryMethod;
    }

    public void setDeliveryMethod(byte[] deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }

    public byte[] getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(byte[] paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Purchase purchase = (Purchase) o;

        if (id != null ? !id.equals(purchase.id) : purchase.id != null) return false;
        if (clientId != null ? !clientId.equals(purchase.clientId) : purchase.clientId != null) return false;
        if (date != null ? !date.equals(purchase.date) : purchase.date != null) return false;
        if (address != null ? !address.equals(purchase.address) : purchase.address != null) return false;
        if (status != null ? !status.equals(purchase.status) : purchase.status != null) return false;
        if (!Arrays.equals(deliveryMethod, purchase.deliveryMethod)) return false;
        if (!Arrays.equals(paymentMethod, purchase.paymentMethod)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (clientId != null ? clientId.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(deliveryMethod);
        result = 31 * result + Arrays.hashCode(paymentMethod);
        return result;
    }

    public Client getClientByClientId() {
        return clientByClientId;
    }

    public void setClientByClientId(Client clientByClientId) {
        this.clientByClientId = clientByClientId;
    }

    public Collection<PurchaseProducts> getPurchaseProductsById() {
        return purchaseProductsById;
    }

    public void setPurchaseProductsById(Collection<PurchaseProducts> purchaseProductsById) {
        this.purchaseProductsById = purchaseProductsById;
    }
}
