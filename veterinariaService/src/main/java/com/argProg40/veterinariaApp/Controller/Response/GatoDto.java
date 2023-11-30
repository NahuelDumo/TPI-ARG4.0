package com.argProg40.veterinariaApp.Controller.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GatoDto {
    private int Id;
    private String nombre;
    private String color;
    private int Edad;
}

