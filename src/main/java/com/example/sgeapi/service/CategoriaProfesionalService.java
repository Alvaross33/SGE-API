package com.example.sgeapi.service;

import com.example.sgeapi.dto.CategoriaProfesionalDTO;
import com.example.sgeapi.model.CategoriaProfesional;
import com.example.sgeapi.repository.CategoriaProfesionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaProfesionalService {

    @Autowired
    private FabricaCategoriaProfesionalService fabricaCategoriaProfesionalService;

    @Autowired
    private CategoriaProfesionalRepository categoriaProfesionalRepository;

    public CategoriaProfesionalDTO save(CategoriaProfesionalDTO categoriaDTO) {
        CategoriaProfesional categoria =
                fabricaCategoriaProfesionalService.createCategoriaProfesional(categoriaDTO);

        CategoriaProfesional categoriaGuardada =
                categoriaProfesionalRepository.save(categoria);

        return fabricaCategoriaProfesionalService
                .createCategoriaProfesionalDTO(categoriaGuardada);
    }

    public List<CategoriaProfesionalDTO> findAll() {
        List<CategoriaProfesional> categorias =
                categoriaProfesionalRepository.findAll();

        return fabricaCategoriaProfesionalService
                .crearCategoriasProfesionalesDTO(categorias);
    }

    public CategoriaProfesionalDTO findById(Integer id) {
        return categoriaProfesionalRepository.findById(id)
                .map(fabricaCategoriaProfesionalService::createCategoriaProfesionalDTO)
                .orElse(null);
    }

    public void deleteById(Integer id) {
        categoriaProfesionalRepository.deleteById(id);
    }
}
