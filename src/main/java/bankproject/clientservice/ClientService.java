package bankproject.clientservice;

import bankproject.Account;
import bankproject.Bank;
import bankproject.Client;
import bankproject.util.HibernateUtil;
import lombok.NoArgsConstructor;
import org.hibernate.Session;


import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@NoArgsConstructor
public class ClientService{

    public void createBank() {
        Session session = openSession();
        session.beginTransaction();
        Bank bank = new Bank();
        bank.setName("SolarisBank");
        bank.setAddress("Warszawa, Kmietowicza 16");
        session.persist(bank);
        session.getTransaction().commit();
        session.close();
    }

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
        if(c != null && c.getAccount() == null) {
            session.beginTransaction();
            session.delete(c);
            session.getTransaction().commit();
            session.close();
        }
    }

    public List<Client> getAllClients(){
        Session session = openSession();
        var query = session.createQuery(
                        "select c from Client c",
                        Client.class);
        List<Client> clientList = query.getResultList();
        session.close();
        return clientList;
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
        if(a != null && Objects.equals(a.getBalance().toString(), BigDecimal.valueOf(0.00) + "0")) {
            session.beginTransaction();
            session.delete(a);
            session.getTransaction().commit();
            session.close();
        }
    }

    public List<Account> getAccountsByClientId(int id){
        Session session = openSession();
        var query = session.createQuery(
                "select a from Account a "+
                        "where acc_cl_id = :id",
                Account.class)
                .setParameter("id", id);

        List<Account> accountList = query.getResultList();
        session.close();
        return accountList;
    }

    public Client findClientById(int id){
        Session session = openSession();
        Client client = session.find(Client.class, id);
        session.close();
        return client;
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

    public Session openSession(){
        return HibernateUtil.getSessionFactory().openSession();
    }
}
