package dzavaPelikany.domain;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "bills")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer billId;
    @Basic
    private String streetNameAndNumber;
    @Basic
    private String description;
    @Basic
    private Double amount;
    @Basic
    private String linkToCopy;
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

    public String getStreetNameAndNumber() {
        return streetNameAndNumber;
    }

    public void setStreetNameAndNumber(String streetNameAndNumber) {
        this.streetNameAndNumber = streetNameAndNumber;
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

    public String getLinkToCopy() {
        return linkToCopy;
    }

    public void setLinkToCopy(String linkToCopy) {
        this.linkToCopy = linkToCopy;
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
