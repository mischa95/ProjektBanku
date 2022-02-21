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
    }

    @Override
    public void deleteAccount(Object o) {

    }

    @Override
    public void newClient(Object o) {
        Session session = openSession();
        session.beginTransaction();
        session.persist(o);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void removeClient(Object o) {

    }

    @Override
    public void payIntoAccount(Object o, BigDecimal amount) {

    }

    @Override
    public void withdrawFromAccount(Object o, BigDecimal amount) {

    }

    @Override
    public String showBalance(Object o) {
        return null;
    }

    private Session openSession(){
        return HibernateUtil.getSessionFactory().openSession();
    }
}
