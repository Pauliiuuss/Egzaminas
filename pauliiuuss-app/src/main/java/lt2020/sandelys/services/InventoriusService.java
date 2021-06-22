package lt2020.sandelys.services;

import lt2020.sandelys.DAO.InventoriusDAO;
import lt2020.sandelys.entities.Inventorius;
import lt2020.sandelys.entities.InventoriusInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class InventoriusService {

    @Autowired
    private InventoriusDAO inventoriusDAO;

    @Transactional(readOnly = true)
    public Collection<InventoriusInfo> grazintiVisusInventorius() {
        return inventoriusDAO.findAll()
                .stream()
                .map(isdb -> new InventoriusInfo(
                        isdb.getId(),
                        isdb.getPavadinimas(),
                        isdb.getSvoris(),
                        isdb.getSektorius(),
                        isdb.getPatalpinimoData(),
                        isdb.getKlientas()))
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public InventoriusInfo grazintiInventoriuPagalId(Long id) {
        Inventorius isdb = inventoriusDAO.findInventoriusById(id);
        return new InventoriusInfo(
                isdb.getId(),
                isdb.getPavadinimas(),
                isdb.getSvoris(),
                isdb.getSektorius(),
                isdb.getPatalpinimoData(),
                isdb.getKlientas());
    }

    @Transactional
    public void pridetiInventoriu(InventoriusInfo inventoriusInfo) {
        Inventorius idb = new Inventorius(
                inventoriusInfo.getPavadinimas(),
                inventoriusInfo.getSvoris(),
                inventoriusInfo.getSektorius(),
                inventoriusInfo.getPatalpinimoData(),
                inventoriusInfo.getKlientas());

        inventoriusDAO.save(idb);
    }

    @Transactional
    public void istrintiInventoriu(Long id) {
        inventoriusDAO.deleteById(id);
    }

    @Transactional
    public void atnaujintiInventoriu(InventoriusInfo inventoriusInfo, Long id) {
        Inventorius isdb = inventoriusDAO.findInventoriusById(id);
        isdb.setPavadinimas(inventoriusInfo.getPavadinimas());
        isdb.setSvoris(inventoriusInfo.getSvoris());
        isdb.setSektorius(inventoriusInfo.getSektorius());
        isdb.setPatalpinimoData(inventoriusInfo.getPatalpinimoData());

        inventoriusDAO.save(isdb);
    }
}
