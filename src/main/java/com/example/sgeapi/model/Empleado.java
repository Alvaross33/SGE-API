package com.example.sgeapi.model;

import jakarta.persistence.*;
import com.example.sgeapi.dto.EmpleadoDTO;

@Entity
@Table(name = "EMPLEADO")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleado")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_categoria", nullable = false)
    private CategoriaProfesional categoriaProfesional;

    @Column(name = "nombre", nullable = false, length = 100)
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

    public Empleado() {}

    public Empleado(Integer id, CategoriaProfesional categoriaProfesional, String nombre, String dni, String telefono, String email, String direccion, String departamento, String rol, String nuss, Boolean esAprobador) {
        this.id = id;
        this.categoriaProfesional = categoriaProfesional;
        this.nombre = nombre;
        this.dni = dni;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
        this.departamento = departamento;
        this.rol = rol;
        this.nuss = nuss;
        this.esAprobador = esAprobador;
    }

    public Empleado(EmpleadoDTO empleadoDTO) {
        this.id = empleadoDTO.getIdEmpleado();
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

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public CategoriaProfesional getCategoriaProfesional() { return categoriaProfesional; }
    public void setCategoriaProfesional(CategoriaProfesional categoriaProfesional) { this.categoriaProfesional = categoriaProfesional; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public String getDepartamento() { return departamento; }
    public void setDepartamento(String departamento) { this.departamento = departamento; }
    public String getRol() { return rol; }
    public void setRol(String rol) { this.rol = rol; }
    public String getNuss() { return nuss; }
    public void setNuss(String nuss) { this.nuss = nuss; }
    public Boolean getEsAprobador() { return esAprobador; }
    public void setEsAprobador(Boolean esAprobador) { this.esAprobador = esAprobador; }
}
