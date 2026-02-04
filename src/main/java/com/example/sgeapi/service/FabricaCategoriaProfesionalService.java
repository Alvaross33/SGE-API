package com.example.sgeapi.service;

import com.example.sgeapi.dto.CategoriaProfesionalDTO;
import com.example.sgeapi.model.CategoriaProfesional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class FabricaCategoriaProfesionalService {

    /**
     * Crea una categoría profesional a partir de un DTO
     */
    public CategoriaProfesional crearCategoriaProfesional(CategoriaProfesionalDTO categoriaDTO) {
        if (categoriaDTO == null) {
            throw new IllegalArgumentException("El DTO de la categoría profesional no puede ser nulo");
        }

        return new CategoriaProfesional(categoriaDTO);
    }

    /**
     * Crea una categoría profesional con valores específicos
     */
    public CategoriaProfesional crearCategoriaProfesional(String descripcion, String nombreCargo, BigDecimal salarioBruto) {
        if (descripcion == null || descripcion.trim().isEmpty()) {
            throw new IllegalArgumentException("La descripción no puede estar vacía");
        }
        if (nombreCargo == null || nombreCargo.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del cargo no puede estar vacío");
        }
        if (salarioBruto == null || salarioBruto.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El salario bruto debe ser mayor que cero");
        }

        CategoriaProfesional categoria = new CategoriaProfesional();
        categoria.setDescripcion(descripcion);
        categoria.setNombreCargo(nombreCargo);
        categoria.setSalarioBruto(salarioBruto);

        return categoria;
    }

    /**
     * Crea una categoría profesional con salario por defecto
     */
    public CategoriaProfesional crearCategoriaProfesionalPorDefecto(String descripcion, String nombreCargo) {
        if (descripcion == null || descripcion.trim().isEmpty()) {
            throw new IllegalArgumentException("La descripción no puede estar vacía");
        }
        if (nombreCargo == null || nombreCargo.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del cargo no puede estar vacío");
        }

        CategoriaProfesional categoria = new CategoriaProfesional();
        categoria.setDescripcion(descripcion);
        categoria.setNombreCargo(nombreCargo);
        categoria.setSalarioBruto(new BigDecimal("1000.00")); // Salario mínimo por defecto

        return categoria;
    }

    /**
     * Actualiza una categoría profesional existente con datos del DTO
     */
    public CategoriaProfesional actualizarCategoriaProfesional(CategoriaProfesional categoriaExistente, CategoriaProfesionalDTO categoriaDTO) {
        if (categoriaExistente == null) {
            throw new IllegalArgumentException("La categoría profesional existente no puede ser nula");
        }
        if (categoriaDTO == null) {
            throw new IllegalArgumentException("El DTO de la categoría profesional no puede ser nulo");
        }

        categoriaExistente.setDescripcion(categoriaDTO.getDescripcion());
        categoriaExistente.setNombreCargo(categoriaDTO.getNombreCargo());
        categoriaExistente.setSalarioBruto(categoriaDTO.getSalarioBruto());

        return categoriaExistente;
    }

    /**
     * Valida que una categoría profesional tenga datos correctos
     */
    public boolean validarCategoriaProfesional(CategoriaProfesional categoria) {
        if (categoria == null) {
            return false;
        }
        if (categoria.getDescripcion() == null || categoria.getDescripcion().trim().isEmpty()) {
            return false;
        }
        if (categoria.getNombreCargo() == null || categoria.getNombreCargo().trim().isEmpty()) {
            return false;
        }
        if (categoria.getSalarioBruto() == null || categoria.getSalarioBruto().compareTo(BigDecimal.ZERO) <= 0) {
            return false;
        }
        return true;
    }
}
