package bankproject;


public class Account {
    private String nameAccount;
    private String currency;
    private double balance;

    //public Account() {
    //}

    public Account(String nameAccount, String currency, double balance) {
        this.currency = currency;
        this.balance = balance;
        this.nameAccount=nameAccount;
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
        return "Stan konta "+nameAccount+" wynosi =" + balance + currency;
    }

}
