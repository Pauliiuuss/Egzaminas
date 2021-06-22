package lt2020.sandelys.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Date;

@Entity
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Inventorius")
public class Inventorius {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @NonNull
    @Column(name = "Pavadinimas")
    private String pavadinimas;

    @NonNull
    @Column(name = "Svoris")
    private double svoris;

    @NonNull
    @Min(1)
    @Max(40)
    @Column(name = "Sektorius")
    private int sektorius;

    @NonNull
    @Column(name = "Pataplinimo_data")
    private Date patalpinimoData;

    @NonNull
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH})
    @JoinColumn(name = "Klientas_id")
    private Klientas klientas;
}
