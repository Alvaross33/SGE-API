package com.example.sgeapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.sgeapi.model.Empleado;,

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {
}
