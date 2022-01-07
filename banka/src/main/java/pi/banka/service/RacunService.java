package pi.banka.service;

import java.util.List;
import java.util.Optional;
import pi.banka.service.dto.RacunDTO;

/**
 * Service Interface for managing {@link pi.banka.domain.Racun}.
 */
public interface RacunService {
    /**
     * Save a racunPrivatnihLica.
     *
     * @param racunPrivatnihLicaDTO the entity to save.
     * @return the persisted entity.
     */
    RacunDTO save(RacunDTO racunPrivatnihLicaDTO);

    /**
     * Get all the racunPrivatnihLicas.
     *
     * @return the list of entities.
     */
    List<RacunDTO> findAll();

    /**
     * Get the "id" racunPrivatnihLica.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<RacunDTO> findOne(Long id);

    /**
     * Delete the "id" racunPrivatnihLica.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
