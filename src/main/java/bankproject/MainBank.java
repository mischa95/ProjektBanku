package bankproject;

import java.math.BigDecimal;
import java.util.List;

public class MainBank {
    public static void main(String[] args) {
        Bank bank1 = new Bank();

        Client client1 = new Client();
        Client client2 = new Client();
        bank1.newClient(client1);
        bank1.newClient(client2);

        Account account1 = new Account("walutowe", "euro", BigDecimal.valueOf(500.5));
        client1.openAccount(account1);
        client1.deleteAccount(account1);
    }
}
