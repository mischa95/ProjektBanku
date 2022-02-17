package bankproject;


import java.util.List;

public class Client {
    private int clientId;
    private String firstName;
    private String lastName;
    private List<Account> accountList;

    public Client(int clientId, List<Account> accountList) {
        this.clientId = clientId;
        this.accountList = accountList
    }

    public Account openAccount(int clientId, Account account) {
        return new Account();
    }

    public void deleteAccount(Account account) {

    }
}
