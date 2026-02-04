package com.example.sgeapi.service;

import com.example.sgeapi.dto.CategoriaProfesionalDTO;
import com.example.sgeapi.model.CategoriaProfesional;
import com.example.sgeapi.repository.CategoriaProfesionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaProfesionalService {

    @Autowired
    private CategoriaProfesionalRepository categoriaProfesionalRepository;

    public CategoriaProfesionalDTO save(CategoriaProfesionalDTO categoriaDTO) {
        if (categoriaDTO == null) {
            throw new IllegalArgumentException("La categoría profesional no puede ser nula");
        }

        CategoriaProfesional categoria = new CategoriaProfesional(categoriaDTO);
        CategoriaProfesional categoriaGuardada = categoriaProfesionalRepository.save(categoria);
        return new CategoriaProfesionalDTO(categoriaGuardada);
    }

    public CategoriaProfesionalDTO update(Integer id, CategoriaProfesionalDTO categoriaDTO) {
        if (categoriaDTO == null) {
            throw new IllegalArgumentException("La categoría profesional no puede ser nula");
        }

        CategoriaProfesional categoria = categoriaProfesionalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoría profesional no encontrada con id: " + id));

        categoria.setDescripcion(categoriaDTO.getDescripcion());
        categoria.setNombreCargo(categoriaDTO.getNombreCargo());
        categoria.setSalarioBruto(categoriaDTO.getSalarioBruto());

        CategoriaProfesional categoriaActualizada = categoriaProfesionalRepository.save(categoria);
        return new CategoriaProfesionalDTO(categoriaActualizada);
    }

    public List<CategoriaProfesionalDTO> findAll() {
        return categoriaProfesionalRepository.findAll().stream()
                .map(CategoriaProfesionalDTO::new)
                .collect(Collectors.toList());
    }

    public CategoriaProfesionalDTO findById(Integer id) {
        return categoriaProfesionalRepository.findById(id)
                .map(CategoriaProfesionalDTO::new)
                .orElseThrow(() -> new RuntimeException("Categoría profesional no encontrada con id: " + id));
    }

    public void deleteById(Integer id) {
        if (!categoriaProfesionalRepository.existsById(id)) {
            throw new RuntimeException("Categoría profesional no encontrada con id: " + id);
        }
        categoriaProfesionalRepository.deleteById(id);
    }
}
