package pi.banka.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import pi.banka.domain.Racun;

/**
 * Spring Data SQL repository for the RacunPrivatnihLica entity.
 */
@SuppressWarnings("unused")
@Repository
public interface RacunRepository extends JpaRepository<Racun, Long> {}
