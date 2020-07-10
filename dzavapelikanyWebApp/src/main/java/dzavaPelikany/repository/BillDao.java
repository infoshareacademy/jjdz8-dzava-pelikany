package dzavaPelikany.repository;

import dzavaPelikany.domain.Bill;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Stateless
public class BillDao implements Dao<Bill> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Bill bill) {
        entityManager.persist(bill);
    }

    @Override
    public void update(Bill bill) {
        entityManager.merge(bill);
    }

    public void delete(Bill bill){
        entityManager.remove(bill);
    }


    @Override
    public Optional<Bill> findUserByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public List<Bill> findAll() {
        return null;
    }

    @Override
    public Optional<Bill> findUserById(Long id) {
        return Optional.empty();
    }
}
