package com.example.sgeapi.service;

import com.example.sgeapi.dto.EmpleadoDTO;
import com.example.sgeapi.model.Empleado;
import com.example.sgeapi.model.CategoriaProfesional;
import com.example.sgeapi.repository.CategoriaProfesionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FabricaEmpleadoService {

    @Autowired
    private CategoriaProfesionalRepository categoriaProfesionalRepository;

    /**
     * Crea un empleado a partir de un DTO, asignando la categoría profesional correspondiente
     */
    public Empleado crearEmpleado(EmpleadoDTO empleadoDTO) {
        if (empleadoDTO == null) {
            throw new IllegalArgumentException("El DTO del empleado no puede ser nulo");
        }

        Empleado empleado = new Empleado(empleadoDTO);

        // Asignar categoría profesional si existe
        if (empleadoDTO.getIdCategoria() != null) {
            CategoriaProfesional categoria = categoriaProfesionalRepository.findById(empleadoDTO.getIdCategoria())
                    .orElseThrow(() -> new RuntimeException("Categoría profesional no encontrada con id: " + empleadoDTO.getIdCategoria()));
            empleado.setCategoriaProfesional(categoria);
        }

        return empleado;
    }

    /**
     * Crea un empleado con valores por defecto
     */
    public Empleado crearEmpleadoPorDefecto(String nombre, Integer idCategoria) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del empleado no puede estar vacío");
        }

        Empleado empleado = new Empleado();
        empleado.setNombre(nombre);
        empleado.setEsAprobador(false);

        if (idCategoria != null) {
            CategoriaProfesional categoria = categoriaProfesionalRepository.findById(idCategoria)
                    .orElseThrow(() -> new RuntimeException("Categoría profesional no encontrada con id: " + idCategoria));
            empleado.setCategoriaProfesional(categoria);
        }

        return empleado;
    }

    /**
     * Actualiza un empleado existente con datos del DTO
     */
    public Empleado actualizarEmpleado(Empleado empleadoExistente, EmpleadoDTO empleadoDTO) {
        if (empleadoExistente == null) {
            throw new IllegalArgumentException("El empleado existente no puede ser nulo");
        }
        if (empleadoDTO == null) {
            throw new IllegalArgumentException("El DTO del empleado no puede ser nulo");
        }

        empleadoExistente.setNombre(empleadoDTO.getNombre());
        empleadoExistente.setDni(empleadoDTO.getDni());
        empleadoExistente.setTelefono(empleadoDTO.getTelefono());
        empleadoExistente.setEmail(empleadoDTO.getEmail());
        empleadoExistente.setDireccion(empleadoDTO.getDireccion());
        empleadoExistente.setDepartamento(empleadoDTO.getDepartamento());
        empleadoExistente.setRol(empleadoDTO.getRol());
        empleadoExistente.setNuss(empleadoDTO.getNuss());
        empleadoExistente.setEsAprobador(empleadoDTO.getEsAprobador());

        // Actualizar categoría profesional si cambió
        if (empleadoDTO.getIdCategoria() != null) {
            CategoriaProfesional categoria = categoriaProfesionalRepository.findById(empleadoDTO.getIdCategoria())
                    .orElseThrow(() -> new RuntimeException("Categoría profesional no encontrada con id: " + empleadoDTO.getIdCategoria()));
            empleadoExistente.setCategoriaProfesional(categoria);
        }

        return empleadoExistente;
    }
}
