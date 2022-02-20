package bankproject;

import java.util.List;

public class MainBank {
    public static void main(String[] args) {
        Bank bank1 = new Bank();

        Client client1 = new Client();
        Client client2 = new Client();
        bank1.newClient(client1);
        bank1.newClient(client2);
        bank1.deleteClient(client2);




    }
}
