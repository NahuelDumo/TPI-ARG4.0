package com.argProg40.veterinariaApp.Controller;

import com.argProg40.veterinariaApp.Controller.Response.TurnoMedicoDto;
import com.argProg40.veterinariaApp.Services.TurnoMedico.TurnoMedicoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoMedicoController {


    private final TurnoMedicoService turnoMedicoService;

    public TurnoMedicoController(TurnoMedicoService turnoMedicoService) {
        this.turnoMedicoService = turnoMedicoService;
    }


    // Constructor y otros métodos

    @GetMapping
    public ResponseEntity<List<TurnoMedicoDto>> obtenerTodosLosTurnos() {
        List<TurnoMedicoDto> turnos = turnoMedicoService.obtenerTodosLosTurnos();
        return new ResponseEntity<>(turnos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TurnoMedicoDto> obtenerTurnoPorId(@PathVariable Long id) {
        TurnoMedicoDto turno = turnoMedicoService.obtenerTurnoPorId(id);
        return turno != null
                ? new ResponseEntity<>(turno, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Void> crearTurno(@RequestBody TurnoMedicoDto turnoMedicoDto) {
        turnoMedicoService.crearTurno(turnoMedicoDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> AprobarTurno(@PathVariable int id ) {
        turnoMedicoService.AprobarTurno(id);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{idMedico}")
    public ResponseEntity<List<TurnoMedicoDto>> obtenerTodosLosTurnosDeUnMedico(@PathVariable Long idMedico) {
        List<TurnoMedicoDto> turnos = turnoMedicoService.obtenerTodosLosTurnosMedico(idMedico);
        return new ResponseEntity<>(turnos, HttpStatus.OK);
    }



    // Otros métodos para actualizar y eliminar turnos
}
