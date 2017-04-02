package module03.repository;

import module03.entity.Project;
import org.hibernate.Session;

import javax.transaction.Transactional;
import java.util.List;

public class ProjectRepository extends BaseRepository {
    @Override
    @Transactional
    public List<Project> read ()
    {
        final Session session = getSession();
        session.beginTransaction();
        List<Project> list = session.createNativeQuery("SELECT * FROM projects",Project.class).list();
        session.close();
        return list;
    }

}
