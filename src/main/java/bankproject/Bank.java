package bankproject;

import java.util.List;

public class Bank {
    private int bankId;
    private List<Client> clientList;

    public Bank() {
    }

    public List<Client> newClient(int clientId, String firstName, String lastName) {
        Client client = new Client();
        client.setClientId(clientId);
        client.setFirstName(firstName);
        client.setLastName(lastName);
        clientList.add(client);
        return clientList;
    }

    public void deleteClient(Client client){
        clientList.remove(client);
    }
}
