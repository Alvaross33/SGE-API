package com.example.sgeapi.service;

import com.example.sgeapi.dto.NominaDTO;
import com.example.sgeapi.model.Nomina;
import com.example.sgeapi.model.CategoriaProfesional;
import com.example.sgeapi.repository.NominaRepository;
import com.example.sgeapi.repository.EmpleadoRepository;
import com.example.sgeapi.repository.CategoriaProfesionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.math.BigDecimal;

@Service
public class NominaService {

    @Autowired
    private NominaRepository nominaRepository;

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Autowired
    private CategoriaProfesionalRepository categoriaProfesionalRepository;

    /**
     * Obtener todas las nóminas con todos sus campos
     */
    public List<NominaDTO> findAll() {
        return nominaRepository.findAll().stream()
                .map(NominaDTO::new)
                .collect(Collectors.toList());
    }

    /**
     * Obtener nómina por ID con información del empleado
     */
    public com.example.sgeapi.dto.NominaDetalleDTO findByIdDetalle(Integer id) {
        Nomina nomina = nominaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nómina no encontrada con id: " + id));
        return new com.example.sgeapi.dto.NominaDetalleDTO(nomina);
    }

    public NominaDTO findById(Integer id) {
        return nominaRepository.findById(id)
                .map(NominaDTO::new)
                .orElseThrow(() -> new RuntimeException("Nómina no encontrada con id: " + id));
    }

    public NominaDTO save(NominaDTO nominaDTO) {
        Nomina nomina = new Nomina(nominaDTO);

        if (nominaDTO.getIdEmpleado() != null) {
            nomina.setEmpleado(empleadoRepository.findById(nominaDTO.getIdEmpleado()).orElse(null));
        }

        CategoriaProfesional categoria = null;
        if (nominaDTO.getIdCargo() != null) {
            categoria = categoriaProfesionalRepository.findById(nominaDTO.getIdCargo()).orElse(null);
            nomina.setCategoriaProfesional(categoria);
        }

        if (categoria != null) {
            nomina.setCategoriaProfesional(categoria);
        } else if (nominaDTO.getSalarioBruto() != null) {
            CategoriaProfesional catPorSalario = categoriaProfesionalRepository.findBySalarioBruto(nominaDTO.getSalarioBruto()).orElse(null);
            if (catPorSalario != null && nomina.getCategoriaProfesional() == null) {
                nomina.setCategoriaProfesional(catPorSalario);
            }
        }

        BigDecimal salarioBruto = nomina.getSalarioBruto();
        BigDecimal deduccionesInput = nominaDTO.getDeducciones();

        if (salarioBruto != null && deduccionesInput != null) {
            BigDecimal montoDeduccion;

            if (deduccionesInput.compareTo(BigDecimal.ONE) <= 0 && deduccionesInput.compareTo(BigDecimal.ZERO) > 0) {
                montoDeduccion = salarioBruto.multiply(deduccionesInput);
            } else {
                montoDeduccion = deduccionesInput;
            }

            nomina.setDeducciones(montoDeduccion);
            nomina.setSalarioNeto(salarioBruto.subtract(montoDeduccion));
        }

        return new NominaDTO(nominaRepository.save(nomina));
    }

    public void deleteById(Integer id) {
        nominaRepository.deleteById(id);
    }
}
