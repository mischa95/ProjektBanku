package bankproject;


import java.util.ArrayList;
import java.util.List;

public class Client {
    private int clientId;
    private String firstName;
    private String lastName;
    private List<Account> accountList = new ArrayList<>();

    public Client(){
    }

    public Client(String firstName, String lastName, int clientId){
        this.firstName=firstName;
        this.lastName=lastName;
        this.clientId=clientId;
    }


    public List<Account> openAccount(String nameAccount, String curency, double balance) {
        Account account = new Account(nameAccount, curency, balance);
        accountList.add(account);
        return accountList;
    }

    public void deleteAccount(Account account) {
        accountList.remove(account);
    }

    public void payIntoAccount(Account account, double amount) {
        if(amount>0)
            account.setBalance(account.getBalance()+amount);
        else{
            System.out.println("Nie możesz wpłacić ujemnej kwoty !!!");
        }
    }

    public void withdraw(Account account, double amount) {
        if((account.getBalance()-amount) >= 0)
            account.setBalance(account.getBalance()-amount);
        else{
            System.out.println("Nie masz tyle środków na koncie !!!");
        }
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
