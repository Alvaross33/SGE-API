package com.example.sgeapi.service;

import org.springframework.stereotype.Service;
import com.example.sgeapi.dto.EmpleadoDTO;
import com.example.sgeapi.model.Empleado;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FabricaEmpleadoService {

    public Empleado crearEmpleado(EmpleadoDTO empleadoDTO) {
        return new Empleado(empleadoDTO);
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
