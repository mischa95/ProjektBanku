package bankproject.clientservice;

import bankproject.Account;
import bankproject.Client;
import bankproject.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ClientServiceTest {

    ClientService clientService;
    Account account;
    Client client;


    @BeforeEach
    public void create() {
        clientService = new ClientService();
        account = new Account();
        account.setBalance(BigDecimal.valueOf(100));
        clientService.openAccount(account);
    }

    @Test
    void payInto() {
        clientService.payIntoAccount(account.getAccountId(), BigDecimal.valueOf(20));
        Account account1 = clientService.findAccountById(account.getAccountId());

        assertEquals(BigDecimal.valueOf(120.00).stripTrailingZeros(), account1.getBalance().stripTrailingZeros());
    }

    @AfterEach
    public void drop() {
        clientService.closeAccount(account.getAccountId());
    }

    @Test
    void withdraw() {
        ClientService clientService = new ClientService();
        Account account = new Account();
        account.setBalance(BigDecimal.valueOf(100));
        clientService.openAccount(account);

        clientService.withdrawFromAccount(account.getAccountId(), BigDecimal.valueOf(20));
        BigDecimal balance = account.getBalance();

        assertEquals(BigDecimal.valueOf(80), balance);
    }
}