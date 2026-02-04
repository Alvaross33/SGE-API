package com.example.sgeapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.sgeapi.dto.EmpleadoDTO;
import com.example.sgeapi.model.Empleado;
import com.example.sgeapi.repository.CategoriaProfesionalRepository;
import com.example.sgeapi.repository.EmpleadoRepository;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Autowired
    private CategoriaProfesionalRepository categoriaProfesionalRepository;

    public EmpleadoDTO save(EmpleadoDTO empleadoDTO) {
        Empleado empleado = new Empleado(empleadoDTO);
        if (empleadoDTO.getIdCategoria() != null) {
            empleado.setCategoriaProfesional(categoriaProfesionalRepository.findById(empleadoDTO.getIdCategoria()).orElse(null));
        }
        Empleado empleadoGuardado = empleadoRepository.save(empleado);
        return new EmpleadoDTO(empleadoGuardado);
    }

    public List<EmpleadoDTO> findAll() {
        return empleadoRepository.findAll().stream()
                .map(EmpleadoDTO::new)
                .collect(Collectors.toList());
    }

    public EmpleadoDTO findById(Integer id) {
        return empleadoRepository.findById(id)
                .map(EmpleadoDTO::new)
                .orElse(null);
    }

    public void deleteById(Integer id) {
        empleadoRepository.deleteById(id);
    }
}
