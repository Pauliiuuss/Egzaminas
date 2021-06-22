package lt2020.sandelys.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoriusInfo {

    private Long id;
    private String pavadinimas;
    private double svoris;
    private int sektorius;
    private Date patalpinimoData;
    private Klientas klientas;

}
