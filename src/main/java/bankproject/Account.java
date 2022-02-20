package bankproject;


public class Account {
    private String currency;
    private double balance;
    private String accountName;


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

    public void setCurrency(String currency){
        this.currency = currency;
    }


    public String showBalance() {
        return "Stan konta wynosi " + balance + currency;
    }

}
