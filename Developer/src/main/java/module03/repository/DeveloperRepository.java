package module03.repository;

import module03.entity.Developer;
import org.hibernate.Session;

import javax.transaction.Transactional;
import java.util.List;

public class DeveloperRepository extends BaseRepository {

    @Override
    @Transactional
    public List<Developer> read ()
    {
        final Session session = getSession();
        session.beginTransaction();
        List<Developer> list = session.createNativeQuery("SELECT * FROM developers",Developer.class).list();
        session.close();
        return list;
    }

}
