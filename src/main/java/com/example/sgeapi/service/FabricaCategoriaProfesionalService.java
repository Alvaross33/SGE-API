package com.example.sgeapi.service;

import com.example.sgeapi.dto.CategoriaProfesionalDTO;
import com.example.sgeapi.model.CategoriaProfesional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FabricaCategoriaProfesionalService {

    // 1️⃣ DTO → Entity
    public CategoriaProfesional createCategoriaProfesional(CategoriaProfesionalDTO dto) {
        CategoriaProfesional categoria = new CategoriaProfesional();
        categoria.setIdCategoriaP(dto.getIdCategoriaP());
        categoria.setDescripcion(dto.getDescripcion());
        categoria.setNombreCargo(dto.getNombreCargo());
        categoria.setSalarioBruto(dto.getSalarioBruto());
        return categoria;
    }

    // 2️⃣ Entity → DTO
    public CategoriaProfesionalDTO createCategoriaProfesionalDTO(CategoriaProfesional entity) {
        CategoriaProfesionalDTO dto = new CategoriaProfesionalDTO();
        dto.setIdCategoriaP(entity.getIdCategoriaP());
        dto.setDescripcion(entity.getDescripcion());
        dto.setNombreCargo(entity.getNombreCargo());
        dto.setSalarioBruto(entity.getSalarioBruto());
        return dto;
    }

    // 3️⃣ Lista de Entities → Lista de DTOs
    public List<CategoriaProfesionalDTO> crearCategoriasProfesionalesDTO(List<CategoriaProfesional> lista) {
        return lista.stream()
                .map(this::createCategoriaProfesionalDTO)
                .collect(Collectors.toList());
    }
}
