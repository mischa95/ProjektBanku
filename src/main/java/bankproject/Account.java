package bankproject;


public class Account {
    private String currency;
    private double balance;

    public Account() {
    }

    public Account(String currency, double balance) {
        this.currency = currency;
        this.balance = balance;
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
