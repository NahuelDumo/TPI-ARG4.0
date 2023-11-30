package com.argProg40.veterinariaApp.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Mascota")
public class Mascota {
    @Id
    @GeneratedValue(generator = "Mascota")
    @TableGenerator(name = "Mascota", table = "sqlite_sequence",
            pkColumnName = "name", valueColumnName = "seq",
            pkColumnValue="Mascota",
            initialValue = 3 ,allocationSize=1)
    @Column(name = "id")
    private Long id;

    private String nombre;

    private String tipo;

    private String raza;

    private String color;

    private int edad;



}
