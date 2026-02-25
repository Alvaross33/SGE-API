package com.example.sgeapi.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import com.example.sgeapi.model.CategoriaProfesional;
import java.math.BigDecimal;
import java.util.List;

/**
 * DTO detallado de Categoría Profesional que incluye los empleados asignados
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaProfesionalDetalleDTO {
    private Integer idCategoriaP;
    private String descripcion;
    private String nombreCargo;
    private BigDecimal salarioBruto;
    private List<EmpleadoSimpleDTO> empleados;

    public CategoriaProfesionalDetalleDTO(CategoriaProfesional categoria, List<EmpleadoSimpleDTO> empleados) {
        this.idCategoriaP = categoria.getIdCategoriaP();
        this.descripcion = categoria.getDescripcion();
        this.nombreCargo = categoria.getNombreCargo();
        this.salarioBruto = categoria.getSalarioBruto();
        this.empleados = empleados;
    }
}
