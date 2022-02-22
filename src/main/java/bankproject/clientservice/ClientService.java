package bankproject.clientservice;

import bankproject.Account;
import bankproject.Client;
import bankproject.util.HibernateUtil;
import lombok.NoArgsConstructor;
import org.hibernate.Session;

import java.math.BigDecimal;
import java.util.List;

@NoArgsConstructor
public class ClientService{

    public void newClient(Client client) {
        Session session = openSession();
        session.beginTransaction();
        session.persist(client);
        session.getTransaction().commit();
        session.close();
    }

    public void deleteClient(int id) {
        Session session = openSession();
        Client c = session.find(Client.class, id);
        if(c != null) {
            session.beginTransaction();
            session.delete(c);
            session.getTransaction().commit();
            session.close();
        }
    }

    public List<Client> getAllClients(){
        try (Session session = openSession()) {
            return session.createQuery("from "+ Client.class.getName(), Client.class)
                    .getResultList();
        }
    }

    public void openAccount(Account account) {
        Session session = openSession();
        session.beginTransaction();
        session.persist(account);
        session.getTransaction().commit();
        session.close();
    }

    public void closeAccount(int id){
        Session session = openSession();
        Account a = session.find(Account.class, id);
        if(a != null) {
            session.beginTransaction();
            session.delete(a);
            session.getTransaction().commit();
            session.close();
        }
    }

    public List<Account> getAccountsByClientId(int id){
        try (Session session = openSession()) {
            return session.createQuery("from " + Account.class.getName() + "where id =: id",
                            Account.class)
                    .getResultList();
        }
    }

    public void payIntoAccount(int id, BigDecimal amount){
        Session session = openSession();
        session.beginTransaction();
        Account account = session.find(Account.class, id);
        if(account != null) {
            account.setBalance(account.getBalance().add(amount));
            session.update(account);
            session.getTransaction().commit();
        }
        session.close();
    }

    public void withdrawFromAccount(int id, BigDecimal amount){
        Session session = openSession();
        session.beginTransaction();
        Account account = session.find(Account.class, id);
        if(account != null) {
            account.setBalance(account.getBalance().subtract(amount));
            session.update(account);
            session.getTransaction().commit();
        }
        session.close();
    }

    public String showBalance(int id) {
        Session session = openSession();
        session.beginTransaction();
        Account account = session.find(Account.class, id);
        if(account != null) {
            return " Stan konta " + account.getAccountType() + " wynosi = " + account.getBalance() + account.getCurrency();
        }
        session.close();
        return "Konto nie istnieje";
    }

    private static Session openSession(){
        return HibernateUtil.getSessionFactory().openSession();
    }
}
