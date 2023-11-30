package com.argProg40.veterinariaApp.Services.TurnoMedico;

import com.argProg40.veterinariaApp.Controller.Response.TurnoMedicoDto;

import java.util.List;


public interface TurnoMedicoService {

    List<TurnoMedicoDto> obtenerTodosLosTurnos();

    TurnoMedicoDto obtenerTurnoPorId(Long id);

    void crearTurno(TurnoMedicoDto turnoMedicoDto);

    void AprobarTurno(int IdTurno);

    List<TurnoMedicoDto> obtenerTodosLosTurnosMedico(Long id);
}
