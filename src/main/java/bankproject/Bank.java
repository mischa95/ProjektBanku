package bankproject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Bank {
    private int bankId;
    private List<Client> clientList = new ArrayList<>();

    public Bank() {
    }

    public void newClient(Client client) {
        clientList.add(client);
    }

    public void deleteClient(Client client){
        clientList.remove(client);
    }

    public List<Client> getClientList() {
        return clientList;
    }
}
