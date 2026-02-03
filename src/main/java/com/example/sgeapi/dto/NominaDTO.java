package com.example.sgeapi.dto;

import java.time.LocalDate;
import java.math.BigDecimal;
import com.example.sgeapi.model.Nomina;

public class NominaDTO {
    private Integer idNomina;
    private Integer idEmpleado;
    private Integer idCargo;
    private BigDecimal salarioBruto;
    private String periodo;
    private LocalDate fechaPago;
    private BigDecimal salarioNeto;
    private BigDecimal deducciones;

    public NominaDTO() {}

    public NominaDTO(Integer idNomina, Integer idEmpleado, Integer idCargo, BigDecimal salarioBruto, String periodo, LocalDate fechaPago, BigDecimal salarioNeto, BigDecimal deducciones) {
        this.idNomina = idNomina;
        this.idEmpleado = idEmpleado;
        this.idCargo = idCargo;
        this.salarioBruto = salarioBruto;
        this.periodo = periodo;
        this.fechaPago = fechaPago;
        this.salarioNeto = salarioNeto;
        this.deducciones = deducciones;
    }

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

    public Integer getIdNomina() { return idNomina; }
    public void setIdNomina(Integer idNomina) { this.idNomina = idNomina; }
    public Integer getIdEmpleado() { return idEmpleado; }
    public void setIdEmpleado(Integer idEmpleado) { this.idEmpleado = idEmpleado; }
    public Integer getIdCargo() { return idCargo; }
    public void setIdCargo(Integer idCargo) { this.idCargo = idCargo; }
    public BigDecimal getSalarioBruto() { return salarioBruto; }
    public void setSalarioBruto(BigDecimal salarioBruto) { this.salarioBruto = salarioBruto; }
    public String getPeriodo() { return periodo; }
    public void setPeriodo(String periodo) { this.periodo = periodo; }
    public LocalDate getFechaPago() { return fechaPago; }
    public void setFechaPago(LocalDate fechaPago) { this.fechaPago = fechaPago; }
    public BigDecimal getSalarioNeto() { return salarioNeto; }
    public void setSalarioNeto(BigDecimal salarioNeto) { this.salarioNeto = salarioNeto; }
    public BigDecimal getDeducciones() { return deducciones; }
    public void setDeducciones(BigDecimal deducciones) { this.deducciones = deducciones; }
}
