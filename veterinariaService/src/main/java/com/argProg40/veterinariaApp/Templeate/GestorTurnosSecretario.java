package com.argProg40.veterinariaApp.Templeate;

import com.argProg40.veterinariaApp.Controller.Response.MedicoDto;
import com.argProg40.veterinariaApp.Controller.Response.TurnoMedicoDto;
import com.argProg40.veterinariaApp.Controller.TurnoMedicoController;

import java.time.LocalDate;
import java.util.List;

public class GestorTurnosSecretario extends GestorTurnos {

    private final TurnoMedicoController turnoMedicoController;


    public GestorTurnosSecretario(TurnoMedicoController turnoMedicoController) {
        this.turnoMedicoController = turnoMedicoController;

    }

    @Override
    public void registrarTurno(MedicoDto medico, int mascota, Float monto) {
        TurnoMedicoDto turno = new TurnoMedicoDto();
        turno.setMascotaId((long) mascota);
        turno.setMedicoId(medico.getId());
        turno.setMonto(monto);
        turno.setFechaTurno(LocalDate.now());
        turnoMedicoController.crearTurno(turno);
        System.out.println("Turno del veterinario " + medico.getNombre() +  " para la mascota " + turno.getMascotaId() + " Registrado con Exito");
    }

    @Override
    public List<TurnoMedicoDto> mostrarTurnos() {
        return turnoMedicoController.obtenerTodosLosTurnos().getBody();
    }
}

