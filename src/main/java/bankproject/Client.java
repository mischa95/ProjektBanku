package bankproject;


import java.util.List;

public class Client {
    private int clientId;
    private String firstName;
    private String lastName;
    private List<Account> accountList;

    public Client(int clientId, List<Account> accountList) {
        this.clientId = clientId;
        this.accountList = accountList;
    }

    public List<Account> openAccount(int clientId, String firstName, String lastName) {
        Account account = new Account();
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

}
