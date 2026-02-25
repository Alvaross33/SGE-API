package com.example.sgeapi.model;

import jakarta.persistence.*;
import com.example.sgeapi.dto.NominaDTO;
import java.time.LocalDate;
import java.math.BigDecimal;

@Entity
@Table(name="NOMINA")
public class Nomina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_nomina")
    private Integer idNomina;

    @ManyToOne
    @JoinColumn(name = "id_empleado")
    private Empleado empleado;

    @ManyToOne
    @JoinColumn(name = "id_cargo")
    private CategoriaProfesional categoriaProfesional;

    @Column(name = "salario_bruto")
    private BigDecimal salarioBruto;

    @Column(name = "periodo", length = 50)
    private String periodo;

    @Column(name = "fecha_pago")
    private LocalDate fechaPago;

    @Column(name = "salario_neto")
    private BigDecimal salarioNeto;

    @Column(name = "deducciones")
    private BigDecimal deducciones;

    public Nomina() {}

    public Nomina(Integer idNomina, Empleado empleado, CategoriaProfesional categoriaProfesional, BigDecimal salarioBruto, String periodo, LocalDate fechaPago, BigDecimal salarioNeto, BigDecimal deducciones) {
        this.idNomina = idNomina;
        this.empleado = empleado;
        this.categoriaProfesional = categoriaProfesional;
        this.salarioBruto = salarioBruto;
        this.periodo = periodo;
        this.fechaPago = fechaPago;
        this.salarioNeto = salarioNeto;
        this.deducciones = deducciones;
    }

    public Nomina(NominaDTO nominaDTO) {
        this.idNomina = nominaDTO.getIdNomina();
        this.salarioBruto = nominaDTO.getSalarioBruto();
        this.periodo = nominaDTO.getPeriodo();
        this.fechaPago = nominaDTO.getFechaPago();
        this.salarioNeto = nominaDTO.getSalarioNeto();
        this.deducciones = nominaDTO.getDeducciones();
    }

    public Integer getIdNomina() { return idNomina; }
    public void setIdNomina(Integer idNomina) { this.idNomina = idNomina; }
    public Empleado getEmpleado() { return empleado; }
    public void setEmpleado(Empleado empleado) { this.empleado = empleado; }
    public CategoriaProfesional getCategoriaProfesional() { return categoriaProfesional; }
    public void setCategoriaProfesional(CategoriaProfesional categoriaProfesional) { this.categoriaProfesional = categoriaProfesional; }
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
