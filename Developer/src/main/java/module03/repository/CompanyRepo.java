package module03.repository;

import module03.entity.Company;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Properties;

public class CompanyRepo {
        private final SessionFactory concreteSessionFactory;
        {
            try {
                Configuration cfg = new Configuration();
                Properties p = new Properties();
                p.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("hibernate.properties"));
                cfg.setProperties(p);
                cfg.addAnnotatedClass(Company.class);
                concreteSessionFactory = cfg.buildSessionFactory();
            } catch (Throwable ex) {
                throw new ExceptionInInitializerError(ex);
            }
        }

        public Session getSession()
                throws HibernateException {
            return concreteSessionFactory.openSession();
        }

    @Transactional
    public void create(Company company) {
        final Session session = getSession();
        session.beginTransaction();
        session.save(company);
        session.getTransaction().commit();
        session.close();
    }
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
