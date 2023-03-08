package aord.controller;

import aord.converter.ToDangerNameConverter;
import aord.converter.ToDangerNameDTOConverter;
import aord.dto.DangerNameDTO;
import aord.service.DangerNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("mechanicalDanger")
public class MechanicalDangerController {

    @Autowired
    DangerNameService service;

    @Autowired
    ToDangerNameDTOConverter toDTO;

    @Autowired
    ToDangerNameConverter toEntity;

    @GetMapping("/getAll")
    public ResponseEntity<List<DangerNameDTO>> getAll() {
        List<DangerNameDTO> mechanicalDangers = toDTO.convert(service.getAll());
        return new ResponseEntity<>(mechanicalDangers, HttpStatus.OK);
    }

    @GetMapping("/findById")
    public ResponseEntity<DangerNameDTO> getById(@RequestParam Long id) {
        DangerNameDTO mechanicalDanger = toDTO.convert(service.getById(id));
        return new ResponseEntity<>(mechanicalDanger, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody DangerNameDTO mechanicalDanger) {
        service.save(toEntity.convert(mechanicalDanger));
        return new ResponseEntity<>(mechanicalDanger, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Object> update(@RequestBody DangerNameDTO mechanicalDanger) {
        service.update(mechanicalDanger);
        return new ResponseEntity<>(mechanicalDanger, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Object> delete(@RequestParam Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}