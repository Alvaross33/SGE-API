package com.example.sgeapi.dto;

import java.math.BigDecimal;

public class CategoriaProfesionalDTO {

    private Integer idCategoriaP;
    private String descripcion;
    private String nombreCargo;
    private BigDecimal salarioBruto;

    public CategoriaProfesionalDTO() {}

    public CategoriaProfesionalDTO(Integer idCategoriaP, String descripcion, String nombreCargo, BigDecimal salarioBruto) {
        this.idCategoriaP = idCategoriaP;
        this.descripcion = descripcion;
        this.nombreCargo = nombreCargo;
        this.salarioBruto = salarioBruto;
    }

    public Integer getIdCategoriaP() { return idCategoriaP; }
    public void setIdCategoriaP(Integer idCategoriaP) { this.idCategoriaP = idCategoriaP; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public String getNombreCargo() { return nombreCargo; }
    public void setNombreCargo(String nombreCargo) { this.nombreCargo = nombreCargo; }
    public BigDecimal getSalarioBruto() { return salarioBruto; }
    public void setSalarioBruto(BigDecimal salarioBruto) { this.salarioBruto = salarioBruto; }
}
