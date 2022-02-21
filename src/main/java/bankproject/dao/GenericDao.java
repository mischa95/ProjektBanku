package bankproject.dao;

import java.math.BigDecimal;
import java.util.List;

public interface GenericDao<T> {
    void openAccount (T t);
    void deleteAccount(T t);
    void newClient(T t);
    void removeClient(T t);
    void payIntoAccount(T t, BigDecimal amount);
    void withdrawFromAccount(T t, BigDecimal amount);
    List<T> getClientList();
    List<T> getAccountList();
    String showBalance(T t);
}
