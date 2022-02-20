package bankproject;


public class Account {
    private String accountName;
    private String currency;
    private double balance;


    public Account(String accountName, String currency, double balance) {
        this.currency = currency;
        this.balance = balance;
        this.accountName = accountName;
    }

    public double getBalance(){
        return balance;
    }

    public void setBalance(double amount) {
        balance = amount;
    }

    public String showBalance() {
        return "Stan konta "+accountName+" wynosi =" + balance + currency;
    }
}
