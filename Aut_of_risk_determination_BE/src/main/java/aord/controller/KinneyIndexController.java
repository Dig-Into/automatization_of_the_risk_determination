package aord.controller;

import aord.converter.ToKinneyIndexConverter;
import aord.converter.ToKinneyIndexDTOConverter;
import aord.dto.KinneyIndexDTO;
import aord.service.KinneyIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("kinneyIndex")
public class KinneyIndexController {

    @Autowired
    KinneyIndexService service;

    @Autowired
    ToKinneyIndexDTOConverter toDTO;

    @Autowired
    ToKinneyIndexConverter toEntity;

    @GetMapping("/getAll")
    public ResponseEntity<List<KinneyIndexDTO>> getAll() {
        List<KinneyIndexDTO> kinneyIndexes = toDTO.convert(service.getAll());
        return new ResponseEntity<>(kinneyIndexes, HttpStatus.OK);
    }

    @GetMapping("/findById")
    public ResponseEntity<KinneyIndexDTO> getById(@RequestParam Long id) {
        KinneyIndexDTO kinneyIndex = toDTO.convert(service.getById(id));
        return new ResponseEntity<>(kinneyIndex, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody KinneyIndexDTO kinneyIndex) {
        service.save(toEntity.convert(kinneyIndex));
        return new ResponseEntity<>(kinneyIndex, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Object> update(@RequestBody KinneyIndexDTO kinneyIndex) {
        service.update(kinneyIndex);
        return new ResponseEntity<>(kinneyIndex, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Object> delete(@RequestParam Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}