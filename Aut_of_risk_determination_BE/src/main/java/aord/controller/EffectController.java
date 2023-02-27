package aord.controller;

import aord.converter.ToEffectConverter;
import aord.converter.ToEffectDTOConverter;
import aord.dto.EffectDTO;
import aord.service.EffectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("effect")
public class EffectController {

    @Autowired
    EffectService service;

    @Autowired
    ToEffectDTOConverter toDTO;

    @Autowired
    ToEffectConverter toEntity;

    @GetMapping("/getAll")
    public ResponseEntity<List<EffectDTO>> getAll() {
        List<EffectDTO> effects = toDTO.convert(service.getAll());
        return new ResponseEntity<>(effects, HttpStatus.OK);
    }

    @GetMapping("/findById")
    public ResponseEntity<EffectDTO> getById(@RequestParam Long id) {
        EffectDTO effect = toDTO.convert(service.getById(id));
        return new ResponseEntity<>(effect, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody EffectDTO effect) {
        service.save(toEntity.convert(effect));
        return new ResponseEntity<>(effect, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Object> update(@RequestBody EffectDTO effect) {
        service.update(effect);
        return new ResponseEntity<>(effect, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Object> delete(@RequestParam Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}