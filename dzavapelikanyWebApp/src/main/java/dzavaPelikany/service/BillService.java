package dzavaPelikany.service;

import dzavaPelikany.domain.Bill;
import dzavaPelikany.dto.BillView;
import dzavaPelikany.mapper.BillMapper;
import dzavaPelikany.oauth.GoogleLogoutServlet;
import dzavaPelikany.repository.Dao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    private static final Logger LOGGER = LoggerFactory.getLogger(BillService.class.getName());

    public void addBill(Bill bill){
        billDao.save(bill);
        LOGGER.info("bill added: " + bill);
    }

    public List<BillView> findByAddress(String address){
        List<Bill> billList = billDao.findByAddress(address);
        List<BillView> billViewList = new ArrayList<>();
        for (Bill bill: billList) {
            billViewList.add(billMapper.toView(bill));
            }
        return billViewList;
    }




}
