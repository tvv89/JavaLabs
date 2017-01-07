package homework;

import java.util.List;

/**
 * Created by Volodymyr Tymchuk on 25.12.2016 for JavaLabs.
 */
public interface AbstractDAO <T> {
    T save(T arg);
    void delete(T arg);
    void deleteAll(List T);
    void saveAll(List T);
    List <T> getList();
    void deleteById(long Id);
    T get(long Id);

}
