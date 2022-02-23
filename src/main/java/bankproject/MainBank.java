package bankproject;

import bankproject.clientservice.ClientService;
import java.math.BigDecimal;

public class MainBank {
    public static void main(String[] args) {
        ClientService clientService = new ClientService();
        clientService.createBank();

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

        Account account3 = new Account();
        account3.setClient(client);
        account3.setAccountType("oszczednosciowe");
        account3.setBalance(BigDecimal.valueOf(10.000));
        account3.setCurrency("PLN");
        clientService.openAccount(account3);

        Account account4 = new Account();
        account4.setClient(clientService.findClientById(1));
        account4.setAccountType("vat");
        account4.setBalance(BigDecimal.valueOf(53000));
        account4.setCurrency("PLN");
        clientService.openAccount(account4);

        //clientService.closeAccount(2);
        clientService.deleteClient(1);
        clientService.withdrawFromAccount(1,BigDecimal.valueOf(4000));
        clientService.closeAccount(1);

        clientService.payIntoAccount(2,BigDecimal.valueOf(20));
        clientService.withdrawFromAccount(1,BigDecimal.valueOf(1000));
        clientService.closeAccount(1);


        System.out.println(clientService.showBalance(2));

        System.out.println(clientService.getAllClients());
        System.out.println(clientService.getAccountsByClientId(1));
    }
}
