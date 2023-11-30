package com.argProg40.veterinariaApp.Services.Perro;


import com.argProg40.veterinariaApp.Controller.Response.PerroDto;

import java.util.List;

public interface PerroService {

    List<PerroDto> obtenerTodosLosPerros();

    PerroDto obtenerPerroPorId(Long id);

    void crearPerro(PerroDto perroDto);

    // Otros métodos para actualizar y eliminar perros
}

