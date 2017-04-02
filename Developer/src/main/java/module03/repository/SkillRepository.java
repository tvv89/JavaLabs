package module03.repository;

import module03.entity.Skill;
import org.hibernate.Session;

import javax.transaction.Transactional;
import java.util.List;

public class SkillRepository extends BaseRepository{
    @Override
    @Transactional
    public List<Skill> read ()
    {
        final Session session = getSession();
        session.beginTransaction();
        List<Skill> list = session.createNativeQuery("SELECT * FROM skills",Skill.class).list();
        session.close();
        return list;
    }

}
