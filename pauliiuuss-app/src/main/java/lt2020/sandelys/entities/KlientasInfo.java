package lt2020.sandelys.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lt2020.sandelys.misc.KlientoTipas;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KlientasInfo {

    private Long id;
    private String vardas;
    private String pavarde;
    private Date gimimoData;
    private Long telNumeris;
    private KlientoTipas klientoTipas;

}
