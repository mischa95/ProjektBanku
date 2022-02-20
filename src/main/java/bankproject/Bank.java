package bankproject;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BNK_ID")
    private int bankId;
    @ManyToOne(fetch = FetchType.LAZY)
    //adnotacja dodaje kolumne z id klienta posiadajacego dane konto
    @JoinColumn(name = "ACC_CL_ID", referencedColumnName = "CL_ID")
    private Client client;

/*
    public void newClient(Client client) {
        clientList.add(client);
    }

    public void deleteClient(Client client){
        clientList.remove(client);
    }

    public List<Client> getClientList() {
        return clientList;
    }

 */
}
