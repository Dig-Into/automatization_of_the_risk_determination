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
@RequestMapping("dangerName")
public class DangerNameController {

    @Autowired
    DangerNameService service;

    @Autowired
    ToDangerNameDTOConverter toDTO;

    @Autowired
    ToDangerNameConverter toEntity;

    @GetMapping("/getAll")
    public ResponseEntity<List<DangerNameDTO>> getAll() {
        List<DangerNameDTO> dangerNames = toDTO.convert(service.getAll());
        return new ResponseEntity<>(dangerNames, HttpStatus.OK);
    }

    @GetMapping("/findById")
    public ResponseEntity<DangerNameDTO> getById(@RequestParam Long id) {
        DangerNameDTO dangerName = toDTO.convert(service.getById(id));
        return new ResponseEntity<>(dangerName, HttpStatus.OK);
    }

    @GetMapping("/getAllCodes")
    public ResponseEntity<List<Integer>> getAllDangerNameCodes() {
        List<Integer> codes = service.getAllDangerNameCodes();
        return new ResponseEntity<>(codes, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody DangerNameDTO dangerName) {
        service.save(toEntity.convert(dangerName));
        return new ResponseEntity<>(dangerName, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Object> update(@RequestBody DangerNameDTO dangerName) {
        service.update(dangerName);
        return new ResponseEntity<>(dangerName, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Object> delete(@RequestParam Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}