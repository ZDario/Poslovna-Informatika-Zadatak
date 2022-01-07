package pi.banka.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pi.banka.domain.Klijent;
import pi.banka.repository.KlijentRepository;
import pi.banka.service.KlijentService;
import pi.banka.service.dto.KlijentDTO;
import pi.banka.service.mapper.KlijentMapper;

/**
 * Service Implementation for managing {@link Klijent}.
 */
@Service
@Transactional
public class KlijentServiceImpl implements KlijentService {

    private final Logger log = LoggerFactory.getLogger(KlijentServiceImpl.class);

    private final KlijentRepository klijentRepository;

    private final KlijentMapper klijentMapper;

    public KlijentServiceImpl(KlijentRepository klijentRepository, KlijentMapper klijentMapper) {
        this.klijentRepository = klijentRepository;
        this.klijentMapper = klijentMapper;
    }

    @Override
    public KlijentDTO save(KlijentDTO klijentDTO) {
        log.debug("Request to save Klijent : {}", klijentDTO);
        Klijent klijent = klijentMapper.toEntity(klijentDTO);
        klijent = klijentRepository.save(klijent);
        return klijentMapper.toDto(klijent);
    }

    @Override
    @Transactional(readOnly = true)
    public List<KlijentDTO> findAll() {
        log.debug("Request to get all Klijents");
        return klijentRepository.findAll().stream().map(klijentMapper::toDto).collect(Collectors.toCollection(LinkedList::new));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<KlijentDTO> findOne(Long id) {
        log.debug("Request to get Klijent : {}", id);
        return klijentRepository.findById(id).map(klijentMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Klijent : {}", id);
        klijentRepository.deleteById(id);
    }
}
