package bankproject;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ACC_ID")
    private int accountId;
    @Column(name = "ACC_TYPE")
    private String accountType;
    @Column(name = "ACC_BALANCE")
    private double balance;
    @Column(name = "ACC_CURRANCY")
    private String currency;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACC_CL_ID", referencedColumnName = "CL_ID")
    private Client client;


    public Account(String accountName, String currency, double balance) {
        this.currency = currency;
        this.balance = balance;
        this.accountType = accountName;
    }

    public double getBalance(){
        return balance;
    }

    public void setBalance(double amount) {
        balance = amount;
    }

    public String showBalance() {
        return "Stan konta "+accountType+" wynosi =" + balance + currency;
    }
}
