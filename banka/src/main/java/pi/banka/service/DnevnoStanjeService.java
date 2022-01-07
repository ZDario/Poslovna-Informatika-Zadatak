package pi.banka.service;

import java.util.List;
import java.util.Optional;
import pi.banka.service.dto.DnevnoStanjeDTO;

/**
 * Service Interface for managing {@link pi.banka.domain.DnevnoStanje}.
 */
public interface DnevnoStanjeService {
    /**
     * Save a dnevnoStanje.
     *
     * @param dnevnoStanjeDTO the entity to save.
     * @return the persisted entity.
     */
    DnevnoStanjeDTO save(DnevnoStanjeDTO dnevnoStanjeDTO);

    /**
     * Get all the dnevnoStanjes.
     *
     * @return the list of entities.
     */
    List<DnevnoStanjeDTO> findAll();

    /**
     * Get the "id" dnevnoStanje.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<DnevnoStanjeDTO> findOne(Long id);

    /**
     * Delete the "id" dnevnoStanje.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
