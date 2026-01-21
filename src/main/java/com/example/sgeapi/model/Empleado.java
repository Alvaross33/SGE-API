package com.example.sgeapi.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.sgeapi.dto.EmpleadoDTO;

@Data
@NoArgsConstructor
@Entity
@Table(name = "empleados")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleado")
    private Integer idEmpleado;

    @Column(length = 100)
    private String nombre;

    @Column(length = 20)
    private String dni;

    @Column(length = 100)
    private String telefono;

    @Column(length = 100)
    private String email;

    @Column(length = 100)
    private String direccion;

    @Column(length = 50)
    private String departamento;

    @Column(length = 50)
    private String rol;

    @Column(length = 20)
    private String nuss;

    @Column(name = "es_aprobador")
    private Boolean esAprobador;

    public Empleado(EmpleadoDTO empleadoDTO) {
        this.idEmpleado = empleadoDTO.getIdEmpleado();
        this.nombre = empleadoDTO.getNombre();
        this.dni = empleadoDTO.getDni();
        this.telefono = empleadoDTO.getTelefono();
        this.email = empleadoDTO.getEmail();
        this.direccion = empleadoDTO.getDireccion();
        this.departamento = empleadoDTO.getDepartamento();
        this.rol = empleadoDTO.getRol();
        this.nuss = empleadoDTO.getNuss();
        this.esAprobador = empleadoDTO.getEsAprobador();
    }
}
