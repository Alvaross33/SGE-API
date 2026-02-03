package com.example.sgeapi.dto;

import com.example.sgeapi.model.Empleado;

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

    public EmpleadoDTO() {}

    public EmpleadoDTO(Integer idEmpleado, String nombre, String dni, String telefono, String email, String direccion, String departamento, String rol, String nuss, Boolean esAprobador, Integer idCategoria) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.dni = dni;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
        this.departamento = departamento;
        this.rol = rol;
        this.nuss = nuss;
        this.esAprobador = esAprobador;
        this.idCategoria = idCategoria;
    }

    public EmpleadoDTO(Empleado empleado) {
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
        if (empleado.getCategoriaProfesional() != null) {
            this.idCategoria = empleado.getCategoriaProfesional().getIdCategoriaP();
        }
    }

    public Integer getIdEmpleado() { return idEmpleado; }
    public void setIdEmpleado(Integer idEmpleado) { this.idEmpleado = idEmpleado; }
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
    public Integer getIdCategoria() { return idCategoria; }
    public void setIdCategoria(Integer idCategoria) { this.idCategoria = idCategoria; }
}
