package com.example.sgeapi.repository;

import com.example.sgeapi.model.Empleado;
import com.example.sgeapi.model.CategoriaProfesional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {
    List<Empleado> findByCategoriaProfesional(CategoriaProfesional categoriaProfesional);
}
