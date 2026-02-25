package com.example.sgeapi.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import com.example.sgeapi.model.Empleado;
import java.util.List;

/**
 * DTO detallado de Empleado que incluye categoría profesional y nóminas
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpleadoDetalleDTO {
    private Integer idEmpleado;
    private String nombre;
    private String dni;
    private String telefono;
    private String email;
    private String direccion;
    private String departamento;
    private String rol;
    private String nuss;
    private Boolean esAprobador;
    private CategoriaProfesionalDTO categoriaProfesional;
    private List<NominaDTO> nominas;

    public EmpleadoDetalleDTO(Empleado empleado, CategoriaProfesionalDTO categoria, List<NominaDTO> nominas) {
        this.idEmpleado = empleado.getId();
        this.nombre = empleado.getNombre();
        this.dni = empleado.getDni();
        this.telefono = empleado.getTelefono();
        this.email = empleado.getEmail();
        this.direccion = empleado.getDireccion();
        this.departamento = empleado.getDepartamento();
        this.rol = empleado.getRol();
        this.nuss = empleado.getNuss();
        this.esAprobador = empleado.getEsAprobador();
        this.categoriaProfesional = categoria;
        this.nominas = nominas;
    }
}
