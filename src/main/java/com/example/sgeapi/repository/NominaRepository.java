package com.example.sgeapi.repository;

import com.example.sgeapi.model.Nomina;
import com.example.sgeapi.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface NominaRepository extends JpaRepository<Nomina, Integer> {
    List<Nomina> findByEmpleado(Empleado empleado);
}
