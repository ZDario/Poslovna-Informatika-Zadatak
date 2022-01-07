package pi.banka.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import pi.banka.domain.AnalitikaIzvoda;

/**
 * Spring Data SQL repository for the AnalitikaIzvoda entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AnalitikaIzvodaRepository extends JpaRepository<AnalitikaIzvoda, Long> {}
