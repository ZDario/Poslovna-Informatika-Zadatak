package pi.banka.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pi.banka.domain.Banka;
import pi.banka.repository.BankaRepository;
import pi.banka.service.BankaService;
import pi.banka.service.dto.BankaDTO;
import pi.banka.service.mapper.BankaMapper;

/**
 * Service Implementation for managing {@link Banka}.
 */
@Service
@Transactional
public class BankaServiceImpl implements BankaService {

    private final Logger log = LoggerFactory.getLogger(BankaServiceImpl.class);

    private final BankaRepository bankaRepository;

    private final BankaMapper bankaMapper;

    public BankaServiceImpl(BankaRepository bankaRepository, BankaMapper bankaMapper) {
        this.bankaRepository = bankaRepository;
        this.bankaMapper = bankaMapper;
    }

    @Override
    public BankaDTO save(BankaDTO bankaDTO) {
        log.debug("Request to save Banka : {}", bankaDTO);
        Banka banka = bankaMapper.toEntity(bankaDTO);
        banka = bankaRepository.save(banka);
        return bankaMapper.toDto(banka);
    }

    @Override
    @Transactional(readOnly = true)
    public List<BankaDTO> findAll() {
        log.debug("Request to get all Bankas");
        return bankaRepository.findAll().stream().map(bankaMapper::toDto).collect(Collectors.toCollection(LinkedList::new));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<BankaDTO> findOne(Long id) {
        log.debug("Request to get Banka : {}", id);
        return bankaRepository.findById(id).map(bankaMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Banka : {}", id);
        bankaRepository.deleteById(id);
    }
}
