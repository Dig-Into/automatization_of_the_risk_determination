package aord.controller;

import aord.converter.ToDangerDetailsConverter;
import aord.converter.ToDangerDetailsDTOConverter;
import aord.dto.DangerDetailsDTO;
import aord.service.DangerDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("dangerDetails")
public class DangerDetailsController {

    @Autowired
    DangerDetailsService service;

    @Autowired
    ToDangerDetailsDTOConverter toDTO;

    @Autowired
    ToDangerDetailsConverter toEntity;

    @GetMapping("/getAll")
    public ResponseEntity<List<DangerDetailsDTO>> getAll() {
        List<DangerDetailsDTO> dangerDetails = toDTO.convert(service.getAll());
        return new ResponseEntity<>(dangerDetails, HttpStatus.OK);
    }

    @GetMapping("/findById")
    public ResponseEntity<DangerDetailsDTO> getById(@RequestParam Long id) {
        DangerDetailsDTO dangerDetail = toDTO.convert(service.getById(id));
        return new ResponseEntity<>(dangerDetail, HttpStatus.OK);
    }

    @GetMapping("getByCode")
    public ResponseEntity<DangerDetailsDTO> getByCode(@RequestParam Integer code) {
        DangerDetailsDTO dangerDetails = toDTO.convert(service.findDangerDetailsByCode(code));
        return new ResponseEntity<>(dangerDetails, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody DangerDetailsDTO dangerDetails) {
        service.save(toEntity.convert(dangerDetails));
        return new ResponseEntity<>(dangerDetails, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Object> update(@RequestBody DangerDetailsDTO dangerDetails) {
        service.update(dangerDetails);
        return new ResponseEntity<>(dangerDetails, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Object> delete(@RequestParam Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}