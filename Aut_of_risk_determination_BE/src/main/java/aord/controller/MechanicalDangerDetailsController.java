package aord.controller;

import aord.converter.ToDangerDetailsConverter;
import aord.converter.ToMechanicalDangerDetailsDTOConverter;
import aord.dto.DangerDetailsDTO;
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
    ToDangerDetailsConverter toEntity;

    @GetMapping("/getAll")
    public ResponseEntity<List<DangerDetailsDTO>> getAll() {
        List<DangerDetailsDTO> mechanicalDangerDetails = toDTO.convert(service.getAll());
        return new ResponseEntity<>(mechanicalDangerDetails, HttpStatus.OK);
    }

    @GetMapping("/findById")
    public ResponseEntity<DangerDetailsDTO> getById(@RequestParam Long id) {
        DangerDetailsDTO mechanicalDangerDetails = toDTO.convert(service.getById(id));
        return new ResponseEntity<>(mechanicalDangerDetails, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody DangerDetailsDTO mechanicalDangerDetails) {
        service.save(toEntity.convert(mechanicalDangerDetails));
        return new ResponseEntity<>(mechanicalDangerDetails, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Object> update(@RequestBody DangerDetailsDTO mechanicalDangerDetails) {
        service.update(mechanicalDangerDetails);
        return new ResponseEntity<>(mechanicalDangerDetails, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Object> delete(@RequestParam Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}