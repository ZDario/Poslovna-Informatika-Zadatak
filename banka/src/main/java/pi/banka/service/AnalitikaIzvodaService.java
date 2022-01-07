package pi.banka.service;

import java.util.List;
import java.util.Optional;
import pi.banka.service.dto.AnalitikaIzvodaDTO;

/**
 * Service Interface for managing {@link pi.banka.domain.AnalitikaIzvoda}.
 */
public interface AnalitikaIzvodaService {
    /**
     * Save a analitikaIzvoda.
     *
     * @param analitikaIzvodaDTO the entity to save.
     * @return the persisted entity.
     */
    AnalitikaIzvodaDTO save(AnalitikaIzvodaDTO analitikaIzvodaDTO);

    /**
     * Get all the analitikaIzvodas.
     *
     * @return the list of entities.
     */
    List<AnalitikaIzvodaDTO> findAll();

    /**
     * Get the "id" analitikaIzvoda.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<AnalitikaIzvodaDTO> findOne(Long id);

    /**
     * Delete the "id" analitikaIzvoda.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
