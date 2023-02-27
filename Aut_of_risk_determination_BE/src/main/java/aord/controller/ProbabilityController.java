package aord.controller;

import aord.converter.ToProbabilityConverter;
import aord.converter.ToProbabilityDTOConverter;
import aord.dto.ProbabilityDTO;
import aord.service.ProbabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("probability")
public class ProbabilityController {

    @Autowired
    ProbabilityService service;

    @Autowired
    ToProbabilityDTOConverter toDTO;

    @Autowired
    ToProbabilityConverter toEntity;

    @GetMapping("/getAll")
    public ResponseEntity<List<ProbabilityDTO>> getAll() {
        List<ProbabilityDTO> probabilities = toDTO.convert(service.getAll());
        return new ResponseEntity<>(probabilities, HttpStatus.OK);
    }

    @GetMapping("/findById")
    public ResponseEntity<ProbabilityDTO> getById(@RequestParam Long id) {
        ProbabilityDTO probability = toDTO.convert(service.getById(id));
        return new ResponseEntity<>(probability, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody ProbabilityDTO probability) {
        service.save(toEntity.convert(probability));
        return new ResponseEntity<>(probability, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Object> update(@RequestBody ProbabilityDTO probability) {
        service.update(probability);
        return new ResponseEntity<>(probability, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Object> delete(@RequestParam Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}