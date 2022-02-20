package bankproject;


import java.math.BigDecimal;
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


    public void openAccount(Account account) {
        accountList.add(account);
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void deleteAccount(Account account) {
        accountList.remove(account);
    }

    public void payIntoAccount(Account account, BigDecimal amount) {
        if(amount.intValue()>0)
            account.setBalance(account.getBalance().add(amount));
        else{
            System.out.println("Nie możesz wpłacić ujemnej kwoty !!!");
        }
    }

    public void withdraw(Account account, BigDecimal amount) {
        if((account.getBalance().subtract(amount)).intValue() >= 0)
            account.setBalance(account.getBalance().subtract(amount));
        else{
            System.out.println("Nie masz tyle środków na koncie !!!");
        }
    }
}
