package bankproject.dao;

import java.math.BigDecimal;
import java.util.List;

public interface GenericDao<T> {
    void openNew(T t);
    void delete(T t);
    List<T> getAll();

}
