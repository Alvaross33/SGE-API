package com.example.sgeapi.service;

import com.example.sgeapi.dto.NominaDTO;
import com.example.sgeapi.model.Nomina;
import com.example.sgeapi.repository.NominaRepository;
import com.example.sgeapi.repository.EmpleadoRepository;
import com.example.sgeapi.repository.CategoriaProfesionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NominaService {

    @Autowired
    private NominaRepository nominaRepository;

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Autowired
    private CategoriaProfesionalRepository categoriaProfesionalRepository;

    public List<NominaDTO> findAll() {
        return nominaRepository.findAll().stream()
                .map(NominaDTO::new)
                .collect(Collectors.toList());
    }

    public NominaDTO findById(Integer id) {
        return nominaRepository.findById(id)
                .map(NominaDTO::new)
                .orElse(null);
    }

    public NominaDTO save(NominaDTO nominaDTO) {
        Nomina nomina = new Nomina(nominaDTO);
        if (nominaDTO.getIdEmpleado() != null) {
            nomina.setEmpleado(empleadoRepository.findById(nominaDTO.getIdEmpleado()).orElse(null));
        }
        if (nominaDTO.getIdCargo() != null) {
            nomina.setCategoriaProfesional(categoriaProfesionalRepository.findById(nominaDTO.getIdCargo()).orElse(null));
        }
        return new NominaDTO(nominaRepository.save(nomina));
    }

    public void deleteById(Integer id) {
        nominaRepository.deleteById(id);
    }
}
