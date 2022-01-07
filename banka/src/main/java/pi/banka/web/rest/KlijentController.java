package pi.banka.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pi.banka.repository.KlijentRepository;
import pi.banka.service.KlijentService;
import pi.banka.service.dto.KlijentDTO;
/**
 * REST controller for managing {@link pi.banka.domain.Klijent}.
 */
@RestController
@RequestMapping("/api/klijenti")
public class KlijentController {

    private final Logger log = LoggerFactory.getLogger(KlijentController.class);

    private final KlijentService klijentService;
    private final KlijentRepository klijentRepository;

    public KlijentController(KlijentService klijentService, KlijentRepository klijentRepository) {
        this.klijentService = klijentService;
        this.klijentRepository = klijentRepository;
    }

    @PostMapping()
    public ResponseEntity<KlijentDTO> createKlijent(@RequestBody KlijentDTO klijentDTO) throws URISyntaxException {
        log.debug("REST request to save Klijent : {}", klijentDTO);
        if (klijentDTO.getId() != null) {
        	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        KlijentDTO result = klijentService.save(klijentDTO);
        return ResponseEntity
            .created(new URI("/api/klijents/" + result.getId()))
            .body(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<KlijentDTO> updateKlijent(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody KlijentDTO klijentDTO
    ) throws URISyntaxException {
        log.debug("REST request to update Klijent : {}, {}", id, klijentDTO);
        if (klijentDTO.getId() == null) {
        	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (!Objects.equals(id, klijentDTO.getId())) {
        	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if (!klijentRepository.existsById(id)) {
        	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        KlijentDTO result = klijentService.save(klijentDTO);
        return ResponseEntity
            .ok()
            .body(result);
    }

    
    @GetMapping()
    public List<KlijentDTO> getAllKlijenti() {
        log.debug("REST request to get all");
        return klijentService.findAll();
    }

    
    @GetMapping("{id}")
    public ResponseEntity<KlijentDTO> getKlijent(@PathVariable Long id) {
        log.debug("REST request to get Klijent : {}", id);
        Optional<KlijentDTO> klijentDTO = klijentService.findOne(id);
        if(klijentDTO.isEmpty()) {
        	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity
                .ok()
                .body(klijentDTO.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteKlijent(@PathVariable Long id) {
        log.debug("REST request to delete Klijent : {}", id);
        klijentService.delete(id);
        return ResponseEntity
            .noContent()
            .build();
    }
}
