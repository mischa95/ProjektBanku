package bankproject;


import java.math.BigDecimal;

public class Account {
    private String accountName;
    private String currency;
    private BigDecimal balance;


    public Account(String accountName, String currency, BigDecimal balance) {
        this.currency = currency;
        this.balance= balance;
        this.accountName = accountName;
    }

    public BigDecimal getBalance(){
        return balance;
    }

    public void setBalance(BigDecimal amount) {
        balance = amount;
    }

    public String showBalance() {
        return "Stan konta "+accountName+" wynosi =" + balance + currency;
    }
}
