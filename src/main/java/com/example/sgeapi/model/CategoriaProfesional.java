package com.example.sgeapi.model;

import jakarta.persistence.*;
import com.example.sgeapi.dto.CategoriaProfesionalDTO;
import java.math.BigDecimal;
import java.io.Serializable;

@Entity
@Table(name = "CATEGORIA_PROFESIONAL")
public class CategoriaProfesional implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria_p")
    private Integer idCategoriaP;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "nombre_cargo")
    private String nombreCargo;

    @Column(name = "salario_bruto")
    private BigDecimal salarioBruto;

    public CategoriaProfesional() {}

    public CategoriaProfesional(Integer idCategoriaP, String descripcion, String nombreCargo, BigDecimal salarioBruto) {
        this.idCategoriaP = idCategoriaP;
        this.descripcion = descripcion;
        this.nombreCargo = nombreCargo;
        this.salarioBruto = salarioBruto;
    }

    public CategoriaProfesional(CategoriaProfesionalDTO categoriaDTO) {
        this.idCategoriaP = categoriaDTO.getIdCategoriaP();
        this.descripcion = categoriaDTO.getDescripcion();
        this.nombreCargo = categoriaDTO.getNombreCargo();
        this.salarioBruto = categoriaDTO.getSalarioBruto();
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
