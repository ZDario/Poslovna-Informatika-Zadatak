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

import pi.banka.repository.BankaRepository;
import pi.banka.service.BankaService;
import pi.banka.service.dto.BankaDTO;

/**
 * REST controller for managing {@link pi.likvidatura.domain.Banka}.
 */
@RestController
@RequestMapping("/api/banke")
public class BankaController {

    private final Logger log = LoggerFactory.getLogger(BankaController.class);

    private final BankaService bankaService;
    private final BankaRepository bankaRepository;

    public BankaController(BankaService bankaService, BankaRepository bankaRepository) {
        this.bankaService = bankaService;
        this.bankaRepository = bankaRepository;
    }

    @PostMapping()
    public ResponseEntity<BankaDTO> createBanka(@RequestBody BankaDTO bankaDTO) throws URISyntaxException {
        log.debug("REST request to save Banka : {}", bankaDTO);
        if (bankaDTO.getId() != null) {
        	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        BankaDTO result = bankaService.save(bankaDTO);
        return ResponseEntity
            .created(new URI("/api/banke/" + result.getId()))
            .body(result);
    }

    
    @PutMapping("/{id}")
    public ResponseEntity<BankaDTO> updateBanka(
        @PathVariable(value = "id", required = true) final Long id,
        @RequestBody BankaDTO bankaDTO
    ) throws URISyntaxException {
    	
        if (bankaDTO.getId() == null) {
        	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (!Objects.equals(id, bankaDTO.getId())) {
        	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if (!bankaRepository.existsById(id)) {
        	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        BankaDTO result = bankaService.save(bankaDTO);
        return ResponseEntity
            .ok()
            .body(result);
    }

    @GetMapping()
    public List<BankaDTO> getAllBanke() {
        return bankaService.findAll();
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<BankaDTO> getBanka(@PathVariable Long id) {
        Optional<BankaDTO> bankaDTO = bankaService.findOne(id);
        
        if(bankaDTO.isEmpty()) {
        	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity
                .ok()
                .body(bankaDTO.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBanka(@PathVariable Long id) {
        bankaService.delete(id);
        return ResponseEntity
            .noContent()
            .build();
    }
}
