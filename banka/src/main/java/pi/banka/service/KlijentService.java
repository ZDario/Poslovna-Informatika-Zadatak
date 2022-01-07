package pi.banka.service;

import java.util.List;
import java.util.Optional;
import pi.banka.service.dto.KlijentDTO;

/**
 * Service Interface for managing {@link pi.banka.domain.Klijent}.
 */
public interface KlijentService {
    /**
     * Save a klijent.
     *
     * @param klijentDTO the entity to save.
     * @return the persisted entity.
     */
    KlijentDTO save(KlijentDTO klijentDTO);

    /**
     * Get all the klijents.
     *
     * @return the list of entities.
     */
    List<KlijentDTO> findAll();

    /**
     * Get the "id" klijent.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<KlijentDTO> findOne(Long id);

    /**
     * Delete the "id" klijent.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
