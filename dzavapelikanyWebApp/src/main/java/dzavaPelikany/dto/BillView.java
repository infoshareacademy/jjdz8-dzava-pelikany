package dzavaPelikany.dto;

import java.time.LocalDate;

public class BillView {

    private String streetNameAndNUmber;
    private LocalDate date;
    private String description;
    private Double amount;
    private String linkToCopy;

    public String getStreetNameAndNUmber() {
        return streetNameAndNUmber;
    }

    public void setStreetNameAndNUmber(String streetNameAndNUmber) {
        this.streetNameAndNUmber = streetNameAndNUmber;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
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
}
