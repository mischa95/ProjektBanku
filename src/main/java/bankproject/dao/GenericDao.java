package bankproject.dao;

public interface GenericDao<T> {
    void openAccount (T t);
}
