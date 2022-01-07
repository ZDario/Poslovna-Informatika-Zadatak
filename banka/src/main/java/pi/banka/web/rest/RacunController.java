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

import pi.banka.repository.RacunRepository;
import pi.banka.service.RacunService;
import pi.banka.service.dto.RacunDTO;

/**
 * REST controller for managing {@link pi.banka.domain.RacunPrivatnihLica}.
 */
@RestController
@RequestMapping("/api/racuni")
public class RacunController {

    private final Logger log = LoggerFactory.getLogger(RacunController.class);
    
    private final RacunService racunService;

    private final RacunRepository racunRepository;

    public RacunController(
    	RacunService racunService,
        RacunRepository racunRepository
    ) {
        this.racunService = racunService;
        this.racunRepository = racunRepository;
    }

    @PostMapping()
    public ResponseEntity<RacunDTO> createRacun(@RequestBody RacunDTO racunDTO)
        throws URISyntaxException {
        log.debug("REST request to save : {}", racunDTO);
        if (racunDTO.getId() != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        RacunDTO result = racunService.save(racunDTO);
        return ResponseEntity
            .created(new URI("/api/racuni/" + result.getId()))
            .body(result);
    }

    
    @PutMapping("/{id}")
    public ResponseEntity<RacunDTO> updateRacun(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody RacunDTO racunDTO
    ) throws URISyntaxException {
        log.debug("REST request to update : {}, {}", id, racunDTO);
        if (racunDTO.getId() == null) {
        	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (!Objects.equals(id, racunDTO.getId())) {
        	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if (!racunRepository.existsById(id)) {
        	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        RacunDTO result = racunService.save(racunDTO);
        return ResponseEntity
            .ok()
            .body(result);
    }

    @GetMapping()
    public List<RacunDTO> getAll() {
        log.debug("REST request to get all");
        return racunService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RacunDTO> getRacun(@PathVariable Long id) {
        log.debug("REST request to get : {}", id);
        Optional<RacunDTO> racunDTO = racunService.findOne(id);
        if(racunDTO.isEmpty()) {
        	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity
                .ok()
                .body(racunDTO.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRacun(@PathVariable Long id) {
        log.debug("REST request to delete : {}", id);
        racunService.delete(id);
        return ResponseEntity
            .noContent()
            .build();
    }
}
