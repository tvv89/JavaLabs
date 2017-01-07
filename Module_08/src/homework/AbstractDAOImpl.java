package homework;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Volodymyr Tymchuk on 25.12.2016 for JavaLabs.
 */
public class AbstractDAOImpl <T> implements AbstractDAO {
    List<T> DB = new ArrayList();

    public AbstractDAOImpl() {
    }

    public AbstractDAOImpl(List DB) {
        this.DB = DB;
    }


    @Override
    public Object save(Object arg) {
        this.DB.add((T)arg);
        return (T) arg;
    }

    @Override
    public void delete(Object arg) {
        this.DB.remove(arg);
    }

    @Override
    public void deleteAll(List T) {
        T.clear();
    }

    @Override
    public void saveAll(List T) {
        this.DB.addAll(T);
    }

    @Override
    public List getList() {
        return this.DB;
    }

    @Override
    public void deleteById(long Id) {

    }

    @Override
    public Object get(long Id) {
        return null;
    }
}
