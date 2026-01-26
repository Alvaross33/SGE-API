package com.example.sgeapi.model;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import com.example.sgeapi.dto.NominaDTO;

@Data
@NoArgsConstructor
@Entity
@Table(name="nominas")
public class Nomina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_nomina;
    private Integer id_empleado;
    private Integer id_categoriaP;
    private Integer salario_bruto;
    private LocalDate periodo;
    private LocalDate fecha_pago;
    private Integer salario_neto;
    private Integer deducciones;
    @OneToMany(mappedBy = "nomina",fetch = FetchType.LAZY)
    @JoinColumn(name="")
    public Nomina{
        this.id_nomina=nominaDTO.getId_Nomina();
        this.id_empleado=nominaDTO.getId_Empleado();
9+        this.id_categoriaP=nominaDTO.getId_CategoriaP();
        this.salario_bruto=nominaDTO.getSalario_Bruto();
        this.periodo=nominaDTO.getPeriodo();
        this.fecha_pago=nominaDTO.getFecha_Pago();
        this.salario_neto=nominaDTO.getSalario_Neto();
        this.deducciones=nominaDTO.getDeducciones();
    }


}
