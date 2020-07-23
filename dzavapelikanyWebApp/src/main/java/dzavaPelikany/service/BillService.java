package dzavaPelikany.service;

import dzavaPelikany.domain.Bill;
import dzavaPelikany.dto.BillView;
import dzavaPelikany.mapper.BillMapper;
import dzavaPelikany.repository.Dao;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@RequestScoped
public class BillService {

    @EJB(beanName = "billDao")
    private Dao<Bill> billDao;

    @Inject
    private BillMapper billMapper;

    public void addBill(Bill bill){
        billDao.save(bill);
    }

    public List<Bill> findByAddress(String address){
        List<Bill> billList = billDao.findByAddress(address);

        return billList;
    }




}
