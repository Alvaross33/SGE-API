package com.example.sgeapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.sgeapi.model.Empleado;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpleadoDTO {
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
    private Integer idCategoria;

    public EmpleadoDTO(Empleado empleado) {
        this.idEmpleado = empleado.getIdEmpleado();
        this.nombre = empleado.getNombre();
        this.dni = empleado.getDni();
        this.telefono = empleado.getTelefono();
        this.email = empleado.getEmail();
        this.direccion = empleado.getDireccion();
        this.departamento = empleado.getDepartamento();
        this.rol = empleado.getRol();
        this.nuss = empleado.getNuss();
        this.esAprobador = empleado.getEsAprobador();
        this.idCategoria = empleado.getIdCategoria();
    }
}
