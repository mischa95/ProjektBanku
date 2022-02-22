package bankproject;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ACC_ID")
    private int accountId;
    @Column(name = "ACC_TYPE")
    private String accountType;
    @Column(name = "ACC_BALANCE")
    private BigDecimal balance;
    @Column(name = "ACC_CURRANCY")
    private String currency;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ACC_CL_ID", referencedColumnName = "CL_ID")
    private Client client;
}
