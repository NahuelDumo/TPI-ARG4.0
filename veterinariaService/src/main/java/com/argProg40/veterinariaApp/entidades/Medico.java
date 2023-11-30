package com.argProg40.veterinariaApp.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Medico")
public class Medico {
    @Id
    @GeneratedValue(generator = "Medico")
    @TableGenerator(name = "Medico", table = "sqlite_sequence",
            pkColumnName = "name", valueColumnName = "seq",
            pkColumnValue="Medico",
            initialValue=0, allocationSize=1)
    @Column(name = "id")
    private Long id;
    private String nombre;


}
