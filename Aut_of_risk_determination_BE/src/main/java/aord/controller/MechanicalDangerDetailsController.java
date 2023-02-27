package aord.controller;

import aord.converter.ToMechanicalDangerDetailsConverter;
import aord.converter.ToMechanicalDangerDetailsDTOConverter;
import aord.dto.MechanicalDangerDetailsDTO;
import aord.service.MechanicalDangerDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("mechanicalDangerDetails")
public class MechanicalDangerDetailsController {

    @Autowired
    MechanicalDangerDetailsService service;

    @Autowired
    ToMechanicalDangerDetailsDTOConverter toDTO;

    @Autowired
    ToMechanicalDangerDetailsConverter toEntity;

    @GetMapping("/getAll")
    public ResponseEntity<List<MechanicalDangerDetailsDTO>> getAll() {
        List<MechanicalDangerDetailsDTO> mechanicalDangerDetails = toDTO.convert(service.getAll());
        return new ResponseEntity<>(mechanicalDangerDetails, HttpStatus.OK);
    }

    @GetMapping("/findById")
    public ResponseEntity<MechanicalDangerDetailsDTO> getById(@RequestParam Long id) {
        MechanicalDangerDetailsDTO mechanicalDangerDetails = toDTO.convert(service.getById(id));
        return new ResponseEntity<>(mechanicalDangerDetails, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody MechanicalDangerDetailsDTO mechanicalDangerDetails) {
        service.save(toEntity.convert(mechanicalDangerDetails));
        return new ResponseEntity<>(mechanicalDangerDetails, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Object> update(@RequestBody MechanicalDangerDetailsDTO mechanicalDangerDetails) {
        service.update(mechanicalDangerDetails);
        return new ResponseEntity<>(mechanicalDangerDetails, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Object> delete(@RequestParam Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}