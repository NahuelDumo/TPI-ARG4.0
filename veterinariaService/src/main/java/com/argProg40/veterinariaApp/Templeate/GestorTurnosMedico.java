package com.argProg40.veterinariaApp.Templeate;

import com.argProg40.veterinariaApp.Controller.Response.MedicoDto;
import com.argProg40.veterinariaApp.Controller.Response.TurnoMedicoDto;
import com.argProg40.veterinariaApp.Controller.TurnoMedicoController;

import java.util.List;

public class GestorTurnosMedico extends GestorTurnos {

    private TurnoMedicoController turnoMedicoController;
    private MedicoDto medico;

    public GestorTurnosMedico(TurnoMedicoController turnoMedicoController, MedicoDto medico) {
        this.turnoMedicoController = turnoMedicoController;
        this.medico = medico;
    }
    public void aprobarTurno(int turnoMedico) {
        // Implementación predeterminada

        turnoMedicoController.AprobarTurno(Math.toIntExact(turnoMedico));
        System.out.println("Turno aprobado");
    }

    @Override
    public List<TurnoMedicoDto> mostrarTurnos() {
        return turnoMedicoController.obtenerTodosLosTurnosDeUnMedico(medico.getId()).getBody();

    }



}
