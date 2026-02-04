package com.example.sgeapi.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDate;
import java.math.BigDecimal;
import com.example.sgeapi.model.Nomina;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NominaDTO {
    private Integer idNomina;
    private Integer idEmpleado;
    private Integer idCargo;
    private BigDecimal salarioBruto;
    private String periodo;
    private LocalDate fechaPago;
    private BigDecimal salarioNeto;
    private BigDecimal deducciones;

    public NominaDTO(Nomina nomina) {
        this.idNomina = nomina.getIdNomina();
        if (nomina.getEmpleado() != null) {
            this.idEmpleado = nomina.getEmpleado().getId();
        }
        if (nomina.getCategoriaProfesional() != null) {
            this.idCargo = nomina.getCategoriaProfesional().getIdCategoriaP();
        }
        this.salarioBruto = nomina.getSalarioBruto();
        this.periodo = nomina.getPeriodo();
        this.fechaPago = nomina.getFechaPago();
        this.salarioNeto = nomina.getSalarioNeto();
        this.deducciones = nomina.getDeducciones();
    }
}
