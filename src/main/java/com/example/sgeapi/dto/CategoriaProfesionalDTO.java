package com.example.sgeapi.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaProfesionalDTO {

    private Integer idCategoriaP;
    private String descripcion;
    private String nombreCargo;
    private BigDecimal salarioBruto;

    public CategoriaProfesionalDTO(com.example.sgeapi.model.CategoriaProfesional categoria) {
        this.idCategoriaP = categoria.getIdCategoriaP();
        this.descripcion = categoria.getDescripcion();
        this.nombreCargo = categoria.getNombreCargo();
        this.salarioBruto = categoria.getSalarioBruto();
    }
}
