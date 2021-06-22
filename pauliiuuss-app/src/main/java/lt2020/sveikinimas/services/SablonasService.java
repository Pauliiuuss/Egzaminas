package lt2020.sveikinimas.services;

import lt2020.sveikinimas.DAO.SablonasDAO;
import lt2020.sveikinimas.entities.SablonasInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class SablonasService {

    @Autowired
    private SablonasDAO sablonasDAO;

    @Transactional(readOnly = true)
    public Collection<SablonasInfo> gautiSablonus() {
        return sablonasDAO.findAll()
                .stream()
                .map(isdb -> new SablonasInfo(
                        isdb.getId(),
                        isdb.getSablonelis()))
                .collect(Collectors.toList());
    }
}
