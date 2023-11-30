package com.argProg40.veterinariaApp.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Gato extends Mascota {
    private String color;
    private int edad;
}
