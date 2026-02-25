package com.example.sgeapi.controller;

import com.example.sgeapi.dto.CategoriaProfesionalDTO;
import com.example.sgeapi.dto.CategoriaProfesionalDetalleDTO;
import com.example.sgeapi.service.CategoriaProfesionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



import java.util.List;

@RestController
@RequestMapping("/categorias-profesionales")
@CrossOrigin(origins = "http://localhost:5173")
public class CategoriaProfesionalController {

    @Autowired
    private CategoriaProfesionalService categoriaProfesionalService;

    // 🔹 GET → obtener todas las categorías profesionales (sin empleados)
    @GetMapping
    public ResponseEntity<List<CategoriaProfesionalDTO>> obtenerCategorias() {
        return new ResponseEntity<>(
                categoriaProfesionalService.findAll(),
                HttpStatus.OK
        );
    }

    // 🔹 GET → obtener una categoría por ID con empleados asignados
    @GetMapping("/{id}")
    public ResponseEntity<CategoriaProfesionalDetalleDTO> obtenerCategoriaPorId(
            @PathVariable Integer id) {
        try {
            CategoriaProfesionalDetalleDTO categoria = categoriaProfesionalService.findByIdDetalle(id);
            return new ResponseEntity<>(categoria, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // 🔹 POST → crear una nueva categoría profesional
    @PostMapping
    public ResponseEntity<CategoriaProfesionalDTO> crearCategoria(
            @RequestBody CategoriaProfesionalDTO categoriaDTO) {

        // Forzamos que sea una creación
        categoriaDTO.setIdCategoriaP(null);

        CategoriaProfesionalDTO nuevaCategoria =
                categoriaProfesionalService.save(categoriaDTO);

        return new ResponseEntity<>(nuevaCategoria, HttpStatus.CREATED);
    }

    // 🔹 PUT → actualizar una categoría profesional
    @PutMapping("/{id}")
    public ResponseEntity<CategoriaProfesionalDTO> actualizarCategoria(
            @PathVariable Integer id,
            @RequestBody CategoriaProfesionalDTO categoriaDTO) {

        if (categoriaProfesionalService.findById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        categoriaDTO.setIdCategoriaP(id);

        CategoriaProfesionalDTO categoriaActualizada =
                categoriaProfesionalService.save(categoriaDTO);

        return new ResponseEntity<>(categoriaActualizada, HttpStatus.OK);
    }

    // 🔹 DELETE → eliminar una categoría profesional
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCategoria(
            @PathVariable Integer id) {

        categoriaProfesionalService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
