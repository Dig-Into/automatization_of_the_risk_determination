package aord.controller;

import aord.converter.ToRiskRemovalMeasurementConverter;
import aord.converter.ToRiskRemovalMeasurementDTOConverter;
import aord.dto.RiskRemovalMeasurementDTO;
import aord.service.RiskRemovalMeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("riskRemovalMeasurement")
public class RiskRemovalMeasurementController {

    @Autowired
    RiskRemovalMeasurementService service;

    @Autowired
    ToRiskRemovalMeasurementDTOConverter toDTO;

    @Autowired
    ToRiskRemovalMeasurementConverter toEntity;

    @GetMapping("/getAll")
    public ResponseEntity<List<RiskRemovalMeasurementDTO>> getAll() {
        List<RiskRemovalMeasurementDTO> riskRemovalMeasurements = toDTO.convert(service.getAll());
        return new ResponseEntity<>(riskRemovalMeasurements, HttpStatus.OK);
    }

    @GetMapping("/findById")
    public ResponseEntity<RiskRemovalMeasurementDTO> getById(@RequestParam Long id) {
        RiskRemovalMeasurementDTO riskRemovalMeasurement = toDTO.convert(service.getById(id));
        return new ResponseEntity<>(riskRemovalMeasurement, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody RiskRemovalMeasurementDTO riskRemovalMeasurement) {
        service.save(toEntity.convert(riskRemovalMeasurement));
        return new ResponseEntity<>(riskRemovalMeasurement, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Object> update(@RequestBody RiskRemovalMeasurementDTO riskRemovalMeasurement) {
        service.update(riskRemovalMeasurement);
        return new ResponseEntity<>(riskRemovalMeasurement, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Object> delete(@RequestParam Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}