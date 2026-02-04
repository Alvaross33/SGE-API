package com.example.sgeapi.controller;

import com.example.sgeapi.dto.NominaDTO;
import com.example.sgeapi.dto.NominaDetalleDTO;
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

    // 🔹 GET → obtener todas las nóminas con todos sus campos
    @GetMapping
    public ResponseEntity<List<NominaDTO>> getAllNominas() {
        return new ResponseEntity<>(nominaService.findAll(), HttpStatus.OK);
    }

    // 🔹 GET → obtener nómina por ID con información del empleado
    @GetMapping("/{id}")
    public ResponseEntity<NominaDetalleDTO> getNominaById(@PathVariable Integer id) {
        try {
            NominaDetalleDTO nominaDetalle = nominaService.findByIdDetalle(id);
            return new ResponseEntity<>(nominaDetalle, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // 🔹 POST → crear una nueva nómina
    @PostMapping
    public ResponseEntity<NominaDTO> createNomina(@RequestBody NominaDTO nominaDTO) {
        nominaDTO.setIdNomina(null);
        NominaDTO nuevaNomina = nominaService.save(nominaDTO);
        return new ResponseEntity<>(nuevaNomina, HttpStatus.CREATED);
    }

    // ❌ UPDATE y DELETE no permitidos para nóminas
}
