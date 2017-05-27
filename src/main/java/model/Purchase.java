package model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by zhigan on 30.03.17.
 */
@Entity
public class Purchase {
    private Long id;
    private Timestamp date;
    private String address;
    private String status;
    private Boolean deliveryMethod;
    private Boolean paymentMethod;
    private Client clientByClientId;
    private Collection<PurchaseProducts> purchaseProductsById;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "date", nullable = false)
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Basic
    @Column(name = "address", nullable = false, length = 255)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "status", nullable = false, length = 10)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "delivery_method", nullable = false)
    public Boolean getDeliveryMethod() {
        return deliveryMethod;
    }

    public void setDeliveryMethod(Boolean deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }

    @Basic
    @Column(name = "payment_method", nullable = false)
    public Boolean getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(Boolean paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Purchase purchase = (Purchase) o;

        if (id != null ? !id.equals(purchase.id) : purchase.id != null) return false;
        if (date != null ? !date.equals(purchase.date) : purchase.date != null) return false;
        if (address != null ? !address.equals(purchase.address) : purchase.address != null) return false;
        if (status != null ? !status.equals(purchase.status) : purchase.status != null) return false;
//        if (!Arrays.equals(deliveryMethod, purchase.deliveryMethod)) return false;
//        if (!Arrays.equals(paymentMethod, purchase.paymentMethod)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
//        result = 31 * result + Arrays.hashCode(deliveryMethod);
//        result = 31 * result + Arrays.hashCode(paymentMethod);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id", nullable = false)
    public Client getClientByClientId() {
        return clientByClientId;
    }

    public void setClientByClientId(Client clientByClientId) {
        this.clientByClientId = clientByClientId;
    }

    @OneToMany(mappedBy = "purchaseByPurchaseId")
    public Collection<PurchaseProducts> getPurchaseProductsById() {
        return purchaseProductsById;
    }

    public void setPurchaseProductsById(Collection<PurchaseProducts> purchaseProductsById) {
        this.purchaseProductsById = purchaseProductsById;
    }
}
