package com.example.sgeapi.service;

import com.example.sgeapi.repository.CategoriaProfesionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.sgeapi.dto.EmpleadoDTO;
import com.example.sgeapi.model.Empleado;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FabricaEmpleadoService {

    @Autowired
    private CategoriaProfesionalRepository categoriaProfesionalRepository;

    public Empleado crearEmpleado(EmpleadoDTO empleadoDTO) {
        Empleado empleado = new Empleado(empleadoDTO);
        if (empleadoDTO.getIdCategoria() != null) {
            empleado.setCategoriaProfesional(categoriaProfesionalRepository.findById(empleadoDTO.getIdCategoria()).orElse(null));
        }
        return empleado;
    }

    public EmpleadoDTO crearEmpleadoDTO(Empleado empleado) {
        return new EmpleadoDTO(empleado);
    }

    public List<EmpleadoDTO> crearEmpleadosDTO(List<Empleado> listaEmpleados) {
        return listaEmpleados.stream()
                .map(this::crearEmpleadoDTO)
                .collect(Collectors.toList());
    }
}
