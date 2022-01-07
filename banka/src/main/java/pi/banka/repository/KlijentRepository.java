package pi.banka.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import pi.banka.domain.Klijent;

/**
 * Spring Data SQL repository for the Klijent entity.
 */
@SuppressWarnings("unused")
@Repository
public interface KlijentRepository extends JpaRepository<Klijent, Long> {}
