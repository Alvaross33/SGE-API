package com.example.sgeapi.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.sgeapi.dto.CategoriaProfesionalDTO;

@Data
@NoArgsConstructor
@Entity
@Table(name = "categoria_profesional")
public class CategoriaProfesional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoriaP")
    private Integer idCategoriaP;

    @Column(name = "id_empleado")
    private Integer idEmpleado;

    @Column
    private String descripcion;

    @Column(name = "nombre_cargo")
    private String nombreCargo;

    @Column(name = "salario_bruto")
    private Double salarioBruto;

    public CategoriaProfesional(CategoriaProfesionalDTO categoriaDTO) {
        this.idCategoriaP = categoriaDTO.getIdCategoriaP();
        this.idEmpleado = categoriaDTO.getIdEmpleado();
        this.descripcion = categoriaDTO.getDescripcion();
        this.nombreCargo = categoriaDTO.getNombreCargo();
        this.salarioBruto = categoriaDTO.getSalarioBruto();
    }
}

