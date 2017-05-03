package model;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Created by zhigan on 30.03.17.
 */
@Entity
public class Client {
    private Long id;
    private String fullname;
    private String address;
    private Integer phone;
    private String email;
    private List<Purchase> purchasesById;

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
    @Column(name = "fullname", nullable = false, length = 127)
    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
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
    @Column(name = "phone", nullable = false, precision = 0)
    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "email", nullable = false, length = 30)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (id != null ? !id.equals(client.id) : client.id != null) return false;
        if (fullname != null ? !fullname.equals(client.fullname) : client.fullname != null) return false;
        if (address != null ? !address.equals(client.address) : client.address != null) return false;
        if (phone != null ? !phone.equals(client.phone) : client.phone != null) return false;
        if (email != null ? !email.equals(client.email) : client.email != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (fullname != null ? fullname.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "clientByClientId")
    public List<Purchase> getPurchasesById() {
        return purchasesById;
    }

    public void setPurchasesById(List<Purchase> purchasesById) {
        this.purchasesById = purchasesById;
    }

    // String Representation:
    @Override
    public String toString() {
        return getFullname() + " (living on " + getAddress() + ")";
    }
}
