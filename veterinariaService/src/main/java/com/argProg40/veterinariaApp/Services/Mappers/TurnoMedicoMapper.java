package com.argProg40.veterinariaApp.Services.Mappers;


import com.argProg40.veterinariaApp.Controller.Response.TurnoMedicoDto;
import com.argProg40.veterinariaApp.entidades.TurnoMedico;

import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class TurnoMedicoMapper implements Function<TurnoMedico, TurnoMedicoDto>{

    @Override
    public TurnoMedicoDto apply(TurnoMedico turnoMedico) {
        return new TurnoMedicoDto(
        turnoMedico.getMascota().getId(),
        turnoMedico.getMedico().getId(),
        turnoMedico.getMonto(),
        turnoMedico.getFechaTurno()
    );
    }
}

