package com.example.sgeapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.sgeapi.dto.EmpleadoDTO;
import com.example.sgeapi.model.Empleado;
import com.example.sgeapi.repository.EmpleadoRepository;
import java.util.List;

@Service
public class EmpleadoService {

    @Autowired
    private FabricaEmpleadoService fabricaEmpleadoService;

    @Autowired
    private EmpleadoRepository empleadoRepository;

    public EmpleadoDTO save(EmpleadoDTO empleadoDTO) {
        Empleado empleado = fabricaEmpleadoService.crearEmpleado(empleadoDTO);
        Empleado empleadoGuardado = empleadoRepository.save(empleado);
        return fabricaEmpleadoService.crearEmpleadoDTO(empleadoGuardado);
    }

    public List<EmpleadoDTO> findAll() {
        List<Empleado> listaEmpleados = empleadoRepository.findAll();
        return fabricaEmpleadoService.crearEmpleadosDTO(listaEmpleados);
    }

    public EmpleadoDTO findById(Integer id) {
        return empleadoRepository.findById(id)
                .map(fabricaEmpleadoService::crearEmpleadoDTO)
                .orElse(null);
    }

    public void deleteById(Integer id) {
        empleadoRepository.deleteById(id);
    }
}
