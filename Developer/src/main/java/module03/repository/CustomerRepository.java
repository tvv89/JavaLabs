package module03.repository;

import module03.entity.Customer;
import org.hibernate.Session;

import javax.transaction.Transactional;
import java.util.List;

public class CustomerRepository extends BaseRepository{

    @Override
    @Transactional
    public List<Customer> read ()
    {
        final Session session = getSession();
        session.beginTransaction();
        List<Customer> list = session.createNativeQuery("SELECT * FROM customers",Customer.class).list();
        session.close();
        return list;
    }


}
