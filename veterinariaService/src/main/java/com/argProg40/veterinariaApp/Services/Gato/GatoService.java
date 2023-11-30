package com.argProg40.veterinariaApp.Services.Gato;

import com.argProg40.veterinariaApp.Controller.Response.GatoDto;

import java.util.List;

public interface GatoService {
    List<GatoDto> obtenerTodosLosGatos();

    GatoDto obtenerGatoPorId(Long id);

    void crearGato(GatoDto gatoDto);

    // Otros métodos para actualizar y eliminar gatos
}

