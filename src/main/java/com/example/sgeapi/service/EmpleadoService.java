package com.example.sgeapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.sgeapi.dto.EmpleadoDTO;
import com.example.sgeapi.dto.EmpleadoDetalleDTO;
import com.example.sgeapi.dto.CategoriaProfesionalDTO;
import com.example.sgeapi.dto.NominaDTO;
import com.example.sgeapi.model.Empleado;
import com.example.sgeapi.model.CategoriaProfesional;
import com.example.sgeapi.model.Nomina;
import com.example.sgeapi.repository.CategoriaProfesionalRepository;
import com.example.sgeapi.repository.EmpleadoRepository;
import com.example.sgeapi.repository.NominaRepository;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Autowired
    private CategoriaProfesionalRepository categoriaProfesionalRepository;

    @Autowired
    private NominaRepository nominaRepository;

    public EmpleadoDTO save(EmpleadoDTO empleadoDTO) {
        if (empleadoDTO == null) {
            throw new IllegalArgumentException("El empleado no puede ser nulo");
        }

        Empleado empleado = new Empleado(empleadoDTO);
        if (empleadoDTO.getIdCategoria() != null) {
            CategoriaProfesional categoria = categoriaProfesionalRepository.findById(empleadoDTO.getIdCategoria())
                    .orElseThrow(() -> new RuntimeException("Categoría profesional no encontrada con id: " + empleadoDTO.getIdCategoria()));
            empleado.setCategoriaProfesional(categoria);
        }
        Empleado empleadoGuardado = empleadoRepository.save(empleado);
        return new EmpleadoDTO(empleadoGuardado);
    }

    public EmpleadoDTO update(Integer id, EmpleadoDTO empleadoDTO) {
        if (empleadoDTO == null) {
            throw new IllegalArgumentException("El empleado no puede ser nulo");
        }

        Empleado empleado = empleadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado con id: " + id));

        empleado.setNombre(empleadoDTO.getNombre());
        empleado.setDni(empleadoDTO.getDni());
        empleado.setTelefono(empleadoDTO.getTelefono());
        empleado.setEmail(empleadoDTO.getEmail());
        empleado.setDireccion(empleadoDTO.getDireccion());
        empleado.setDepartamento(empleadoDTO.getDepartamento());
        empleado.setRol(empleadoDTO.getRol());
        empleado.setNuss(empleadoDTO.getNuss());
        empleado.setEsAprobador(empleadoDTO.getEsAprobador());

        if (empleadoDTO.getIdCategoria() != null) {
            CategoriaProfesional categoria = categoriaProfesionalRepository.findById(empleadoDTO.getIdCategoria())
                    .orElseThrow(() -> new RuntimeException("Categoría profesional no encontrada con id: " + empleadoDTO.getIdCategoria()));
            empleado.setCategoriaProfesional(categoria);
        }

        Empleado empleadoActualizado = empleadoRepository.save(empleado);
        return new EmpleadoDTO(empleadoActualizado);
    }

    /**
     * Obtener todos los empleados con todos sus datos
     */
    public List<EmpleadoDTO> findAll() {
        return empleadoRepository.findAll().stream()
                .map(EmpleadoDTO::new)
                .collect(Collectors.toList());
    }

    /**
     * Obtener empleado por ID con categoría profesional y nóminas
     */
    public EmpleadoDetalleDTO findByIdDetalle(Integer id) {
        Empleado empleado = empleadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado con id: " + id));

        // Obtener categoría profesional
        CategoriaProfesionalDTO categoriaDTO = null;
        if (empleado.getCategoriaProfesional() != null) {
            categoriaDTO = new CategoriaProfesionalDTO(empleado.getCategoriaProfesional());
        }

        // Obtener nóminas del empleado
        List<Nomina> nominas = nominaRepository.findByEmpleado(empleado);
        List<NominaDTO> nominasDTO = nominas.stream()
                .map(NominaDTO::new)
                .collect(Collectors.toList());

        return new EmpleadoDetalleDTO(empleado, categoriaDTO, nominasDTO);
    }

    public EmpleadoDTO findById(Integer id) {
        return empleadoRepository.findById(id)
                .map(EmpleadoDTO::new)
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado con id: " + id));
    }

    public void deleteById(Integer id) {
        if (!empleadoRepository.existsById(id)) {
            throw new RuntimeException("Empleado no encontrado con id: " + id);
        }
        empleadoRepository.deleteById(id);
    }
}
