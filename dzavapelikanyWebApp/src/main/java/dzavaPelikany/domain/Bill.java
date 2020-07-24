package dzavaPelikany.domain;


import javax.persistence.*;
import java.time.LocalDate;
@NamedQueries({
    @NamedQuery(
            name = "Bill.findAll",
            query = "SELECT b FROM Bill b"
    ),
    @NamedQuery(
        name = "Bill.findByAddress",
        query = "SELECT b from Bill b WHERE  b.address LIKE  :address"
)}
)
@Entity
@Table(name = "bills")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer billId;
    @Basic
    private String address;
    @Basic
    private String description;
    @Basic
    private Double amount;
    @Basic
    private Boolean active;
    @Basic
    private LocalDate date;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String streetNameAndNumber) {
        this.address = streetNameAndNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Integer getBillId() {
        return billId;
    }

    public void setBillId(Integer billId) {
        this.billId = billId;
    }
}
