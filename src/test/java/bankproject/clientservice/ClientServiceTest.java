package bankproject.clientservice;

import bankproject.Account;
import bankproject.Client;
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
    }

    @Test
    void payInto() {
        //given
        account.setBalance(BigDecimal.valueOf(100));
        clientService.openAccount(account);
        //when
        clientService.payIntoAccount(account.getAccountId(), BigDecimal.valueOf(20));
        Account tempAccount = clientService.findAccountById(account.getAccountId());
        //then
        assertEquals(BigDecimal.valueOf(120).stripTrailingZeros(), tempAccount.getBalance().stripTrailingZeros());
    }

    @Test
    void withdraw() {
        //given
        account.setBalance(BigDecimal.valueOf(100));
        clientService.openAccount(account);
        //when
        clientService.withdrawFromAccount(account.getAccountId(), BigDecimal.valueOf(20));
        Account tempAccount = clientService.findAccountById(account.getAccountId());
        //then
        assertEquals(BigDecimal.valueOf(80).stripTrailingZeros(), tempAccount.getBalance().stripTrailingZeros());
    }

    @AfterEach
    public void drop() {
        clientService.closeAccount(account.getAccountId());
    }
}