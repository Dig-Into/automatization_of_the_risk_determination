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

    @GetMapping("/findByCode")
    public ResponseEntity<EffectDTO> getByCode(@RequestParam Double code) {
        EffectDTO effect = toDTO.convert(service.findEffectByCode(code));
        return new ResponseEntity<>(effect, HttpStatus.OK);
    }

}