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

import pi.banka.repository.DnevnoStanjeRepository;
import pi.banka.service.DnevnoStanjeService;
import pi.banka.service.dto.DnevnoStanjeDTO;
/**
 * REST controller for managing {@link pi.banka.domain.DnevnoStanje}.
 */
@RestController
@RequestMapping("/api/dnevna-stanja")
public class DnevnoStanjeController {

    private final Logger log = LoggerFactory.getLogger(DnevnoStanjeController.class);

    private final DnevnoStanjeService dnevnoStanjeService;
    private final DnevnoStanjeRepository dnevnoStanjeRepository;

    public DnevnoStanjeController(DnevnoStanjeService dnevnoStanjeService, DnevnoStanjeRepository dnevnoStanjeRepository) {
        this.dnevnoStanjeService = dnevnoStanjeService;
        this.dnevnoStanjeRepository = dnevnoStanjeRepository;
    }
    
    @GetMapping()
    public List<DnevnoStanjeDTO> getAllDnevnaStanja() {
        log.debug("REST request to get all");
        return dnevnoStanjeService.findAll();
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<DnevnoStanjeDTO> getDnevnoStanje(@PathVariable Long id) {
        log.debug("REST request to get DnevnoStanje : {}", id);
        Optional<DnevnoStanjeDTO> dnevnoStanjeDTO = dnevnoStanjeService.findOne(id);
        if(dnevnoStanjeDTO.isEmpty()) {
        	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity
                .ok()
                .body(dnevnoStanjeDTO.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDnevnoStanje(@PathVariable Long id) {
        log.debug("REST request to delete DnevnoStanje : {}", id);
        dnevnoStanjeService.delete(id);
        return ResponseEntity
            .noContent()
            .build();
    }
}
