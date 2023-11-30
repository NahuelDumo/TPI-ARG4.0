package com.argProg40.veterinariaApp.Controller;

import com.argProg40.veterinariaApp.Controller.Request.MedicoRequestDto;
import com.argProg40.veterinariaApp.Controller.Response.MedicoDto;
import com.argProg40.veterinariaApp.Services.Medico.MedicoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
    private final MedicoService medicoService;

    public MedicoController(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    // Constructor y otros métodos

    @GetMapping
    public ResponseEntity<List<MedicoDto>> obtenerTodosLosMedicos() {
        List<MedicoDto> medicos = medicoService.obtenerTodosLosMedicos();
        return new ResponseEntity<>(medicos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicoDto> obtenerMedicoPorId(@PathVariable Long id) {
        MedicoDto medico = medicoService.obtenerMedicoPorId(id);
        return medico != null
                ? new ResponseEntity<>(medico, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Void> crearMedico(@RequestBody MedicoRequestDto medicoDto) {
        medicoService.crearMedico(medicoDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}

