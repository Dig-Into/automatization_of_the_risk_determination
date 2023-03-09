package aord.controller;

import aord.converter.ToFrequencyConverter;
import aord.converter.ToFrequencyDTOConverter;
import aord.dto.FrequencyDTO;
import aord.service.FrequencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("frequency")
public class FrequencyController {

    @Autowired
    FrequencyService service;

    @Autowired
    ToFrequencyDTOConverter toDTO;

    @Autowired
    ToFrequencyConverter toEntity;

    @GetMapping("/getAll")
    public ResponseEntity<List<FrequencyDTO>> getAll() {
        List<FrequencyDTO> frequencies = toDTO.convert(service.getAll());
        return new ResponseEntity<>(frequencies, HttpStatus.OK);
    }

    @GetMapping("/findById")
    public ResponseEntity<FrequencyDTO> getById(@RequestParam Long id) {
        FrequencyDTO frequency = toDTO.convert(service.getById(id));
        return new ResponseEntity<>(frequency, HttpStatus.OK);
    }

}