package dzavaPelikany.service;

import dzavaPelikany.domain.Bill;
import dzavaPelikany.repository.BillDao;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BillService {

    @EJB
    private BillDao billDao;

    public void addBill(Bill bill){
        billDao.save(bill);
    }


}
