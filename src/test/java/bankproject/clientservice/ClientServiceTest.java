package bankproject.clientservice;

import bankproject.Account;
import bankproject.Client;
import bankproject.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ClientServiceTest {


    @Test
    void payInto() {
        ClientService clientService = new ClientService();
        Client client = new Client();
        clientService.newClient(client);
        Account account = new Account();
        account.setBalance(BigDecimal.valueOf(100));
        account.setClient(client);
        clientService.openAccount(account);

        clientService.payIntoAccount(account.getAccountId(), BigDecimal.valueOf(20));
        BigDecimal balance = account.getBalance();

        assertEquals(BigDecimal.valueOf(100), balance);
    }
}