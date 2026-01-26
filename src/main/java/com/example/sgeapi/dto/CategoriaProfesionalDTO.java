package com.example.sgeapi.dto;

public class CategoriaProfesionalDTO {

    private Integer idCategoriaP;
    private Integer idEmpleado;
    private String descripcion;
    private String nombreCargo;
    private Double salarioBruto;

    // Constructor vacío (OBLIGATORIO para Spring)
    public CategoriaProfesionalDTO() {
    }

    // Getters y Setters

    public Integer getIdCategoriaP() {
        return idCategoriaP;
    }

    public void setIdCategoriaP(Integer idCategoriaP) {
        this.idCategoriaP = idCategoriaP;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombreCargo() {
        return nombreCargo;
    }

    public void setNombreCargo(String nombreCargo) {
        this.nombreCargo = nombreCargo;
    }

    public Double getSalarioBruto() {
        return salarioBruto;
    }

    public void setSalarioBruto(Double salarioBruto) {
        this.salarioBruto = salarioBruto;
    }
}
