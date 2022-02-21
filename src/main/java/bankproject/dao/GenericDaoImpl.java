package bankproject.dao;

import bankproject.util.HibernateUtil;
import org.hibernate.Session;

import java.math.BigDecimal;

public class GenericDaoImpl<T> implements GenericDao<T> {
    private Class<T> entityClass;

    public GenericDaoImpl(Class<T> entityClass){
        this.entityClass = entityClass;
    }

    @Override
    public void openAccount(Object o) {
        Session session = openSession();
        session.beginTransaction();
        session.persist(o);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteAccount(T t) {

    }

    @Override
    public void newClient(T t) {

    }

    @Override
    public void removeClient(T t) {

    }

    @Override
    public void payIntoAccount(T t, BigDecimal amount) {

    }

    @Override
    public void withdrawFromAccount(T t, BigDecimal amount) {

    }

    @Override
    public String showBalance(T t) {
        return null;
    }

    private Session openSession(){
        return HibernateUtil.getSessionFactory().openSession();
    }
}
