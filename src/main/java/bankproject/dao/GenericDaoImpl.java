package bankproject.dao;

import bankproject.util.HibernateUtil;
import org.hibernate.Session;

import java.math.BigDecimal;
import java.util.List;

public class GenericDaoImpl<T> implements GenericDao<T> {
    private Class<T> entityClass;

    public GenericDaoImpl(Class<T> entityClass){
        this.entityClass = entityClass;
    }


    @Override
    public void openNew(Object o) {
        Session session = openSession();
        session.beginTransaction();
        session.persist(o);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Object o) {
        Session session = openSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        session.close();

    }



    @Override
    public List<T> getAll() {
        try (Session session = openSession()) {
            return session.createQuery("from "+ entityClass.getName(),
                            entityClass)
                    .getResultList();
        }
    }


    private Session openSession(){
        return HibernateUtil.getSessionFactory().openSession();
    }
}
