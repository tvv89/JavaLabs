package homework;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Volodymyr Tymchuk on 25.12.2016 for JavaLabs.
 */
public class UserDAO extends AbstractDAOImpl{
    List<User> DB = new ArrayList<>();

    public UserDAO(List DB) {
        this.DB = DB;
    }

    @Override
    public void deleteById(long Id) {
        for (User i: DB) {
            if (i.id == Id) DB.remove(i);

        }
    }

    @Override
    public Object get(long Id) {
        for (User i: DB) {
            if (i.id == Id) return i;
        }
        return null;
    }
}
