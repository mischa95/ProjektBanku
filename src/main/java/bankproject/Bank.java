package bankproject;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BNK_ID")
    private int bankId;
    @Column(name = "BNK_NAME")
    private String name;
    @Column(name = "BNK_ADDRESS")
    private String address;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "bank")
    List<Client> client;
}
