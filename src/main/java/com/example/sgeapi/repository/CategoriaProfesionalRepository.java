package com.example.sgeapi.repository;

import com.example.sgeapi.model.CategoriaProfesional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaProfesionalRepository extends JpaRepository<CategoriaProfesional, Integer> {
}
