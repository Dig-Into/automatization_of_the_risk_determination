package aord.controller;

import aord.converter.ToDangerTypeConverter;
import aord.converter.ToDangerTypeDTOConverter;
import aord.dto.DangerTypeDTO;
import aord.service.DangerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("dangerType")
public class DangerTypeController {

    @Autowired
    DangerTypeService service;

    @Autowired
    ToDangerTypeDTOConverter toDTO;

    @Autowired
    ToDangerTypeConverter toEntity;

    @GetMapping("/getAll")
    public ResponseEntity<List<DangerTypeDTO>> getAll() {
        List<DangerTypeDTO> dangerTypes = toDTO.convert(service.getAll());
        return new ResponseEntity<>(dangerTypes, HttpStatus.OK);
    }

    @GetMapping("/findById")
    public ResponseEntity<DangerTypeDTO> getById(@RequestParam Long id) {
        DangerTypeDTO dangerType = toDTO.convert(service.getById(id));
        return new ResponseEntity<>(dangerType, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody DangerTypeDTO dangerType) {
        service.save(toEntity.convert(dangerType));
        return new ResponseEntity<>(dangerType, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Object> update(@RequestBody DangerTypeDTO dangerType) {
        service.update(dangerType);
        return new ResponseEntity<>(dangerType, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Object> delete(@RequestParam Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}