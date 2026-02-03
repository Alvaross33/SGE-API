package com.example.sgeapi.controller;

import com.example.sgeapi.dto.NominaDTO;
import com.example.sgeapi.service.NominaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nominas")
public class NominaController {

    @Autowired
    private NominaService nominaService;

    @GetMapping
    public ResponseEntity<List<NominaDTO>> getAllNominas() {
        return new ResponseEntity<>(nominaService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NominaDTO> getNominaById(@PathVariable Integer id) {
        NominaDTO nominaDTO = nominaService.findById(id);
        if (nominaDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(nominaDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<NominaDTO> createNomina(@RequestBody NominaDTO nominaDTO) {
        nominaDTO.setIdNomina(null);
        NominaDTO nuevaNomina = nominaService.save(nominaDTO);
        return new ResponseEntity<>(nuevaNomina, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NominaDTO> updateNomina(@PathVariable Integer id, @RequestBody NominaDTO nominaDTO) {
        if (nominaService.findById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        nominaDTO.setIdNomina(id);
        NominaDTO nominaActualizada = nominaService.save(nominaDTO);
        return new ResponseEntity<>(nominaActualizada, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNomina(@PathVariable Integer id) {
        nominaService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
