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

    public void deposit(double sum){
        if(sum>0)
            balance = (balance + sum);
        else{
            System.out.println("Nie możesz wpłacić ujemnej kwoty !!!");
        }
    }

    public void payOut (double sum){
        if((balance-sum) >= 0)
            balance = (balance - sum) ;
        else{
            System.out.println("Nie masz tyle środków na koncie !!!");
        }
    }

    public double getBalance(){
        return balance;
    }

    public void setBalance(double sum) {
        balance = sum;
    }


    public String getCurrency() {
        return currency;
    }

}
