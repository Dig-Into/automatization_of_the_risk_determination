package com.aord.aord.controller;

import com.aord.aord.converter.ToProbabilityConverter;
import com.aord.aord.converter.ToProbabilityDTOConverter;
import com.aord.aord.dto.ProbabilityDTO;
import com.aord.aord.service.ProbabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("probability")
public class ProbabilityController {

    @Autowired
    ProbabilityService probabilityService;

    @Autowired
    ToProbabilityDTOConverter toDTO;

    @Autowired
    ToProbabilityConverter toEntity;

    @GetMapping("/getAll")
    public ResponseEntity<List<ProbabilityDTO>> getAll() {
        List<ProbabilityDTO> probabilities = toDTO.convert(probabilityService.getAll());
        return new ResponseEntity<>(probabilities, HttpStatus.OK);
    }

    @GetMapping("/hello")
    public void sayHello() {
        System.out.println("HELLO!!");
    }

}