package com.example.sgeapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.sgeapi.dto.EmpleadoDTO;
import com.example.sgeapi.dto.EmpleadoDetalleDTO;
import com.example.sgeapi.service.EmpleadoService;
import java.util.List;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    // 🔹 GET → obtener todos los empleados con todos sus datos
    @GetMapping
    public ResponseEntity<List<EmpleadoDTO>> obtenerEmpleados() {
        return new ResponseEntity<>(empleadoService.findAll(), HttpStatus.OK);
    }

    // 🔹 GET → obtener empleado por ID con categoría y nóminas
    @GetMapping("/{id}")
    public ResponseEntity<EmpleadoDetalleDTO> obtenerEmpleadoPorId(@PathVariable Integer id) {
        try {
            EmpleadoDetalleDTO empleadoDetalle = empleadoService.findByIdDetalle(id);
            return new ResponseEntity<>(empleadoDetalle, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<EmpleadoDTO> crearEmpleado(@RequestBody EmpleadoDTO empleadoDTO) {
        empleadoDTO.setIdEmpleado(null);
        EmpleadoDTO nuevoEmpleado = empleadoService.save(empleadoDTO);
        return new ResponseEntity<>(nuevoEmpleado, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmpleadoDTO> actualizarEmpleado(@PathVariable Integer id, @RequestBody EmpleadoDTO empleadoDTO) {
        try {
            EmpleadoDTO empleadoActualizado = empleadoService.update(id, empleadoDTO);
            return new ResponseEntity<>(empleadoActualizado, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEmpleado(@PathVariable Integer id) {
        empleadoService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
