package bankproject;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CL_ID")
    private int clientId;
    @Column(name = "CL_FIRST_NAME")
    private String firstName;
    @Column(name = "CL_LAST_NAME")
    private String lastName;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "client")
    List<Account> account;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CL_BNK_ID", referencedColumnName = "BNK_ID")
    private Bank bank;
}
