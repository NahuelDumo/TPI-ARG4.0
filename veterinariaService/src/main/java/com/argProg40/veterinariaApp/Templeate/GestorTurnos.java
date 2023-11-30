package com.argProg40.veterinariaApp.Templeate;

import com.argProg40.veterinariaApp.Controller.Response.MedicoDto;
import com.argProg40.veterinariaApp.Controller.Response.TurnoMedicoDto;
import com.argProg40.veterinariaApp.entidades.TurnoMedico;

import java.util.List;

public abstract class GestorTurnos {


    // Paso específico que puede ser opcionalmente implementado por las subclases
    protected void aprobarTurno(TurnoMedico turnoMedico) {
        // Implementación predeterminada
        turnoMedico.setAprobado(true);
    }


    protected void registrarTurno(MedicoDto medico, int mascota, Float monto){};



    // Paso específico que debe ser implementado por las subclases
    protected abstract List<TurnoMedicoDto> mostrarTurnos();
}
