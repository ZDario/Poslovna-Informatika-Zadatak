package pi.banka.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pi.banka.domain.Racun;
import pi.banka.repository.RacunRepository;
import pi.banka.service.RacunService;
import pi.banka.service.dto.RacunDTO;
import pi.banka.service.mapper.RacunMapper;

/**
 * Service Implementation for managing {@link Racun}.
 */
@Service
@Transactional
public class RacunServiceImpl implements RacunService {

    private final Logger log = LoggerFactory.getLogger(RacunServiceImpl.class);

    private final RacunRepository racunPrivatnihLicaRepository;

    private final RacunMapper racunPrivatnihLicaMapper;

    public RacunServiceImpl(
        RacunRepository racunPrivatnihLicaRepository,
        RacunMapper racunPrivatnihLicaMapper
    ) {
        this.racunPrivatnihLicaRepository = racunPrivatnihLicaRepository;
        this.racunPrivatnihLicaMapper = racunPrivatnihLicaMapper;
    }

    @Override
    public RacunDTO save(RacunDTO racunPrivatnihLicaDTO) {
        log.debug("Request to save RacunPrivatnihLica : {}", racunPrivatnihLicaDTO);
        Racun racunPrivatnihLica = racunPrivatnihLicaMapper.toEntity(racunPrivatnihLicaDTO);
        racunPrivatnihLica = racunPrivatnihLicaRepository.save(racunPrivatnihLica);
        return racunPrivatnihLicaMapper.toDto(racunPrivatnihLica);
    }

    @Override
    @Transactional(readOnly = true)
    public List<RacunDTO> findAll() {
        log.debug("Request to get all RacunPrivatnihLicas");
        return racunPrivatnihLicaRepository
            .findAll()
            .stream()
            .map(racunPrivatnihLicaMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<RacunDTO> findOne(Long id) {
        log.debug("Request to get RacunPrivatnihLica : {}", id);
        return racunPrivatnihLicaRepository.findById(id).map(racunPrivatnihLicaMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete RacunPrivatnihLica : {}", id);
        racunPrivatnihLicaRepository.deleteById(id);
    }
}
