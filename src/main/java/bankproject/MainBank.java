package bankproject;

import bankproject.clientservice.ClientService;
import java.math.BigDecimal;

public class MainBank {
    public static void main(String[] args) {
        ClientService clientService = new ClientService();

        Client client = new Client();
        client.setFirstName("Marcin");
        client.setLastName("Najman");
        clientService.newClient(client);

        Client client2 = new Client();
        client2.setFirstName("Michal");
        client2.setLastName("Tyrala");
        clientService.newClient(client2);

        Account account1 = new Account();
        account1.setClient(client);
        account1.setAccountType("walutowe");
        account1.setBalance(BigDecimal.valueOf(5000));
        account1.setCurrency("$");
        clientService.openAccount(account1);

        Account account2 = new Account();
        account2.setClient(client);
        account2.setAccountType("oszczednosciowe");
        account2.setBalance(BigDecimal.valueOf(10.000));
        account2.setCurrency("PLN");
        clientService.openAccount(account2);

        //clientService.closeAccount(1);
        //clientService.closeAccount(2);
        //clientService.deleteClient(1);

        clientService.payIntoAccount(2,BigDecimal.valueOf(20));
        clientService.withdrawFromAccount(1,BigDecimal.valueOf(1000));

        System.out.println(clientService.showBalance(2));

        //System.out.println(clientService.getAllClients());
        //System.out.println(clientService.getAccountsByClientId(1));
    }
}
