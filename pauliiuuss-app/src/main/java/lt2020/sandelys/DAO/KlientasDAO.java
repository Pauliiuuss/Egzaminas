package lt2020.sandelys.DAO;

import lt2020.sandelys.entities.Klientas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KlientasDAO extends JpaRepository<Klientas, Long> {

    Klientas findKlientasById(Long id);

}
