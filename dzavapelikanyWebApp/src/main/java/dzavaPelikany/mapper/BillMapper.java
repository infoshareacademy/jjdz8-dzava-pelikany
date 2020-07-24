package dzavaPelikany.mapper;

import dzavaPelikany.domain.Bill;
import dzavaPelikany.dto.BillView;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class BillMapper {
    public BillView toView(Bill bill) {
        BillView billView = new BillView();

        billView.setAmount(bill.getAmount());
        billView.setDate(bill.getDate());
        billView.setDescription(bill.getDescription());
        billView.setAddress(bill.getAddress());

        return billView;
    }
}
