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

import pi.banka.repository.AnalitikaIzvodaRepository;
import pi.banka.service.AnalitikaIzvodaService;
import pi.banka.service.dto.AnalitikaIzvodaDTO;

/**
 * REST controller for managing {@link pi.banka.domain.AnalitikaIzvoda}.
 */
@RestController
@RequestMapping("/api/analitike-izvoda")
public class AnalitikaIzvodaController {

    private final Logger log = LoggerFactory.getLogger(AnalitikaIzvodaController.class);

    private final AnalitikaIzvodaService analitikaIzvodaService;
    private final AnalitikaIzvodaRepository analitikaIzvodaRepository;

    public AnalitikaIzvodaController(AnalitikaIzvodaService analitikaIzvodaService, AnalitikaIzvodaRepository analitikaIzvodaRepository) {
        this.analitikaIzvodaService = analitikaIzvodaService;
        this.analitikaIzvodaRepository = analitikaIzvodaRepository;
    }

    @GetMapping()
    public List<AnalitikaIzvodaDTO> getAllAnalitikaIzvoda() {
        log.debug("REST request to get all");
        return analitikaIzvodaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnalitikaIzvodaDTO> getAnalitikaIzvoda(@PathVariable Long id) {
        log.debug("REST request to get AnalitikaIzvoda : {}", id);
        Optional<AnalitikaIzvodaDTO> analitikaIzvodaDTO = analitikaIzvodaService.findOne(id);
        if(analitikaIzvodaDTO.isEmpty()) {
        	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity
                .ok()
                .body(analitikaIzvodaDTO.get());
    }
}
