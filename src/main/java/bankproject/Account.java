package bankproject;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import javax.persistence.*;

//oznaczenie klasy jako encji
@Entity
//adnotacje lomboka, @data tworzy gettery i settery a @noargsconstructor tworzy konstruktor bezargumentowy
@Data
@NoArgsConstructor
public class Account {

    //oznaczenie pola jako identyfikator
    @Id
    //generowanie numeru id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //dodanie pola jako kolumny i nadanie jej nazwy
    @Column(name = "ACC_ID")
    private int accountId;
    @Column(name = "ACC_TYPE")
    private String accountType;
    @Column(name = "ACC_BALANCE")
    private BigDecimal balance;
    @Column(name = "ACC_CURRANCY")
    private String currency;
    //
    @ManyToOne(fetch = FetchType.LAZY)
    //adnotacja dodaje kolumne z id klienta posiadajacego dane konto
    @JoinColumn(name = "ACC_CL_ID", referencedColumnName = "CL_ID")
    private Client client;

/*
    public Account(String accountType, String currency, BigDecimal balance) {
        this.currency = currency;
        this.balance = balance;
        this.accountType = accountType;
    }

    public BigDecimal getBalance(){
        return balance;
    }

    public void setBalance(BigDecimal amount) {
        balance = amount;
    }

    public String showBalance() {
        return "Stan konta "+accountType+" wynosi =" + balance + currency;
    }

 */
}
