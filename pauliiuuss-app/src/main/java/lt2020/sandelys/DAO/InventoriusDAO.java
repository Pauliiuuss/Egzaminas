package lt2020.sandelys.DAO;

import lt2020.sandelys.entities.Inventorius;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoriusDAO extends JpaRepository<Inventorius, Long> {

    Inventorius findInventoriusById(Long id);
}
