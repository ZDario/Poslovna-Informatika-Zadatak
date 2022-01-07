package pi.banka.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pi.banka.domain.DnevnoStanje;
import pi.banka.repository.DnevnoStanjeRepository;
import pi.banka.service.DnevnoStanjeService;
import pi.banka.service.dto.DnevnoStanjeDTO;
import pi.banka.service.mapper.DnevnoStanjeMapper;

/**
 * Service Implementation for managing {@link DnevnoStanje}.
 */
@Service
@Transactional
public class DnevnoStanjeServiceImpl implements DnevnoStanjeService {

    private final Logger log = LoggerFactory.getLogger(DnevnoStanjeServiceImpl.class);

    private final DnevnoStanjeRepository dnevnoStanjeRepository;

    private final DnevnoStanjeMapper dnevnoStanjeMapper;

    public DnevnoStanjeServiceImpl(DnevnoStanjeRepository dnevnoStanjeRepository, DnevnoStanjeMapper dnevnoStanjeMapper) {
        this.dnevnoStanjeRepository = dnevnoStanjeRepository;
        this.dnevnoStanjeMapper = dnevnoStanjeMapper;
    }

    @Override
    public DnevnoStanjeDTO save(DnevnoStanjeDTO dnevnoStanjeDTO) {
        log.debug("Request to save DnevnoStanje : {}", dnevnoStanjeDTO);
        DnevnoStanje dnevnoStanje = dnevnoStanjeMapper.toEntity(dnevnoStanjeDTO);
        dnevnoStanje = dnevnoStanjeRepository.save(dnevnoStanje);
        return dnevnoStanjeMapper.toDto(dnevnoStanje);
    }

    @Override
    @Transactional(readOnly = true)
    public List<DnevnoStanjeDTO> findAll() {
        log.debug("Request to get all DnevnoStanjes");
        return dnevnoStanjeRepository.findAll().stream().map(dnevnoStanjeMapper::toDto).collect(Collectors.toCollection(LinkedList::new));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<DnevnoStanjeDTO> findOne(Long id) {
        log.debug("Request to get DnevnoStanje : {}", id);
        return dnevnoStanjeRepository.findById(id).map(dnevnoStanjeMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete DnevnoStanje : {}", id);
        dnevnoStanjeRepository.deleteById(id);
    }
}
