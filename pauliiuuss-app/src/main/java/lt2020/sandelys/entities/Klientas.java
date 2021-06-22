package lt2020.sandelys.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lt2020.sandelys.misc.KlientoTipas;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "Klientas")
public class Klientas {

    @JsonIgnore
    @OneToMany(mappedBy = "klientas", cascade = {CascadeType.MERGE, CascadeType.DETACH})
    private Set<Inventorius> inventorius;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true)
    private Long id;

    @NonNull
    @Column(name = "Vardas")
    private String vardas;

    @NonNull
    @Column(name = "Pavarde")
    private String pavarde;

    @NonNull
    @Column(name = "Gimimo_data")
    private Date gimimoData;

    @NonNull
    @Column(name = "Telefonas")
    private Long telNumeris;

    @NonNull
    @Enumerated(EnumType.STRING)
    @Column(name = "Kliento_tipas")
    private KlientoTipas klientoTipas;
}
