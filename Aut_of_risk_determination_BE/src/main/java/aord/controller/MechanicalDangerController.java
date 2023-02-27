package aord.controller;

import aord.converter.ToMechanicalDangerConverter;
import aord.converter.ToMechanicalDangerDTOConverter;
import aord.dto.MechanicalDangerDTO;
import aord.model.MechanicalDanger;
import aord.service.MechanicalDangerService;
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
    MechanicalDangerService service;

    @Autowired
    ToMechanicalDangerDTOConverter toDTO;

    @Autowired
    ToMechanicalDangerConverter toEntity;

    @GetMapping("/getAll")
    public ResponseEntity<List<MechanicalDangerDTO>> getAll() {
        List<MechanicalDangerDTO> mechanicalDangers = toDTO.convert(service.getAll());
        return new ResponseEntity<>(mechanicalDangers, HttpStatus.OK);
    }

    @GetMapping("/findById")
    public ResponseEntity<MechanicalDangerDTO> getById(@RequestParam Long id) {
        MechanicalDangerDTO mechanicalDanger = toDTO.convert(service.getById(id));
        return new ResponseEntity<>(mechanicalDanger, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody MechanicalDangerDTO mechanicalDanger) {
        service.save(toEntity.convert(mechanicalDanger));
        return new ResponseEntity<>(mechanicalDanger, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Object> update(@RequestBody MechanicalDangerDTO mechanicalDanger) {
        service.update(mechanicalDanger);
        return new ResponseEntity<>(mechanicalDanger, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Object> delete(@RequestParam Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}