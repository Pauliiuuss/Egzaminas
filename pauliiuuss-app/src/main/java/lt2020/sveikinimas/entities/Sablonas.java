package lt2020.sveikinimas.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Sablonas")
public class Sablonas {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true)
    private Long id;

    @NonNull
    @Column(name = "sablonelis")
    private String sablonelis;
}
