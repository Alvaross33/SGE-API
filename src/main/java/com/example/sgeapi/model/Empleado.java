package com.example.sgeapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.sgeapi.dto.EmpleadoDTO;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "empleado")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleado")
    private Integer idEmpleado;

    @Column(name = "nombre", length = 100)
    private String nombre;

    @Column(name = "dni", length = 20)
    private String dni;

    @Column(name = "telefono", length = 100)
    private String telefono;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "direccion", length = 200)
    private String direccion;

    @Column(name = "departamento", length = 50)
    private String departamento;

    @Column(name = "rol", length = 50)
    private String rol;

    @Column(name = "nuss", length = 20)
    private String nuss;

    @Column(name = "es_aprobador")
    private Boolean esAprobador;

    @Column(name = "id_categoria")
    private Integer idCategoria;

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
        this.idCategoria = empleadoDTO.getIdCategoria();
    }
}
