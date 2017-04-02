package module03.repository;

import module03.entity.Company;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import javax.transaction.Transactional;
import java.util.List;

public class CompanyRepository extends BaseRepository {

    @Override
    @Transactional
    public List<Company> read ()
    {
        final Session session = getSession();
        session.beginTransaction();
        List<Company> list = session.createNativeQuery("SELECT * FROM companies",Company.class).list();
        session.close();
        return list;
    }



}
