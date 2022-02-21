package bankproject.dao;

import bankproject.util.HibernateUtil;
import org.hibernate.Session;

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



    private Session openSession(){
        return HibernateUtil.getSessionFactory().openSession();
    }
}
