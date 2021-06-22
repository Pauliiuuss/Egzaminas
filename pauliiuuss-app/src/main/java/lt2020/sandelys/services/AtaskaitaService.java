package lt2020.sandelys.services;

import lt2020.sandelys.DAO.InventoriusDAO;
import lt2020.sandelys.DAO.KlientasDAO;
import lt2020.sandelys.entities.KlientasInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AtaskaitaService {

    @Autowired
    private KlientasDAO klientasDAO;
    @Autowired
    private InventoriusDAO inventoriusDAO;


    @Transactional
    public List<KlientasInfo> grazintilientoMaxSvorioTop() {
        return inventoriusDAO.findAll(Sort.by("Svoris"))
                .stream()
                .limit(5)
                .map(isdb -> klientasDAO.findKlientasById(isdb.getKlientas().getId()))
                .map(isdb -> new KlientasInfo(
                        isdb.getId(),
                        isdb.getVardas(),
                        isdb.getPavarde(),
                        isdb.getGimimoData(),
                        isdb.getTelNumeris(),
                        isdb.getKlientoTipas()))
                .collect(Collectors.toList());
    }
}
