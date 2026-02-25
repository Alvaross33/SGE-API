package com.example.sgeapi.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import com.example.sgeapi.model.Empleado;

/**
 * DTO simplificado de Empleado para mostrar solo: id, nombre, teléfono y departamento
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpleadoSimpleDTO {
    private Integer idEmpleado;
    private String nombre;
    private String telefono;
    private String departamento;

    public EmpleadoSimpleDTO(Empleado empleado) {
        this.idEmpleado = empleado.getId();
        this.nombre = empleado.getNombre();
        this.telefono = empleado.getTelefono();
        this.departamento = empleado.getDepartamento();
    }
}
