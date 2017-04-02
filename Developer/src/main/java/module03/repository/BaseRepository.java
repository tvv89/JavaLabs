package module03.repository;

import module03.entity.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Properties;

public class BaseRepository <T> {
    private final SessionFactory concreteSessionFactory;
    {
        try {
            Configuration cfg = new Configuration();
            Properties p = new Properties();
            p.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("hibernate.properties"));
            cfg.setProperties(p);
            cfg.addAnnotatedClass(Company.class);
            cfg.addAnnotatedClass(Customer.class);
            cfg.addAnnotatedClass(Developer.class);
            cfg.addAnnotatedClass(Project.class);
            cfg.addAnnotatedClass(Skill.class);
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
    public void create(T t) {
        final Session session = getSession();
        session.beginTransaction();
        session.save(t);
        session.getTransaction().commit();
        session.close();
    }
    @Transactional
    public List<T> read ()
    {
        return null;
    }

    @Transactional
    public void update(T t)
    {
        final Session session = getSession();
        session.beginTransaction();
        session.update(t);
        session.getTransaction().commit();
        session.close();
    }
    @Transactional
    public void delete(T t)
    {
        final Session session = getSession();
        session.beginTransaction();
        session.delete(t);
        session.getTransaction().commit();
        session.close();
    }

}
