package lt2020.sandelys.services;

import lt2020.sandelys.DAO.KlientasDAO;
import lt2020.sandelys.entities.Klientas;
import lt2020.sandelys.entities.KlientasInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class KlientasService {

    @Autowired
    private KlientasDAO klientasDAO;

    @Transactional(readOnly = true)
    public Collection<KlientasInfo> grazintiVisusKlientus() {
        return klientasDAO.findAll()
                .stream()
                .map(isdb -> new KlientasInfo(
                        isdb.getId(),
                        isdb.getVardas(),
                        isdb.getPavarde(),
                        isdb.getGimimoData(),
                        isdb.getTelNumeris(),
                        isdb.getKlientoTipas()))
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public KlientasInfo grazintiKlientaPagalId(Long id) {
        Klientas isdb = klientasDAO.findKlientasById(id);
        return new KlientasInfo(
                isdb.getId(),
                isdb.getVardas(),
                isdb.getPavarde(),
                isdb.getGimimoData(),
                isdb.getTelNumeris(),
                isdb.getKlientoTipas());
    }

    @Transactional
    public void pridetiKlienta(KlientasInfo klientasInfo) {
        Klientas idb = new Klientas(
                klientasInfo.getVardas(),
                klientasInfo.getPavarde(),
                klientasInfo.getGimimoData(),
                klientasInfo.getTelNumeris(),
                klientasInfo.getKlientoTipas());

        klientasDAO.save(idb);
    }

    @Transactional
    public void istrintiKlienta(Long id) {
        klientasDAO.deleteById(id);
    }

    @Transactional
    public void atnaujintiKlienta(KlientasInfo klientasInfo, Long id) {
        Klientas isdb = klientasDAO.findKlientasById(id);
        isdb.setVardas(klientasInfo.getVardas());
        isdb.setPavarde(klientasInfo.getPavarde());
        isdb.setGimimoData(klientasInfo.getGimimoData());
        isdb.setTelNumeris(klientasInfo.getTelNumeris());
        isdb.setKlientoTipas(klientasInfo.getKlientoTipas());

        klientasDAO.save(isdb);
    }
}
