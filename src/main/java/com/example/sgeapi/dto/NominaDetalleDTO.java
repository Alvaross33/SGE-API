package com.example.sgeapi.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import com.example.sgeapi.model.Nomina;
import java.time.LocalDate;
import java.math.BigDecimal;

/**
 * DTO detallado de Nómina que incluye información del empleado
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NominaDetalleDTO {
    private Integer idNomina;
    private Integer idCargo;
    private BigDecimal salarioBruto;
    private String periodo;
    private LocalDate fechaPago;
    private BigDecimal salarioNeto;
    private BigDecimal deducciones;
    private EmpleadoSimpleDTO empleado;

    public NominaDetalleDTO(Nomina nomina) {
        this.idNomina = nomina.getIdNomina();
        if (nomina.getCategoriaProfesional() != null) {
            this.idCargo = nomina.getCategoriaProfesional().getIdCategoriaP();
        }
        this.salarioBruto = nomina.getSalarioBruto();
        this.periodo = nomina.getPeriodo();
        this.fechaPago = nomina.getFechaPago();
        this.salarioNeto = nomina.getSalarioNeto();
        this.deducciones = nomina.getDeducciones();
        if (nomina.getEmpleado() != null) {
            this.empleado = new EmpleadoSimpleDTO(nomina.getEmpleado());
        }
    }
}
