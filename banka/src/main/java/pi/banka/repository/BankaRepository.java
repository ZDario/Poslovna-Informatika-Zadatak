package pi.banka.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import pi.banka.domain.Banka;

/**
 * Spring Data SQL repository for the Banka entity.
 */
@SuppressWarnings("unused")
@Repository
public interface BankaRepository extends JpaRepository<Banka, Long> {}
