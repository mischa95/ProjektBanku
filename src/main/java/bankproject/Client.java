package bankproject;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CL_ID")
    private int clientId;
    @Column(name = "CL_FIRST_NAME")
    private String firstName;
    @Column(name = "CL_LAST_NAME")
    private String lastName;


    private List<Account> accountList;

    /*
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

     */
}
