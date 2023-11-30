package com.argProg40.veterinariaApp.Controller;

import com.argProg40.veterinariaApp.Controller.Response.GatoDto;
import com.argProg40.veterinariaApp.Services.Gato.GatoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gatos")
public class GatoController {
    private final GatoService gatoService;

    public GatoController(GatoService ga) {
        this.gatoService = ga;
    }

    // Constructor y otros métodos

    @GetMapping
    public ResponseEntity<List<GatoDto>> obtenerTodosLosGatos() {
        List<GatoDto> gatos = gatoService.obtenerTodosLosGatos();
        return new ResponseEntity<>(gatos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GatoDto> obtenerGatoPorId(@PathVariable Long id) {
        GatoDto gato = gatoService.obtenerGatoPorId(id);
        return gato != null
                ? new ResponseEntity<>(gato, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Void> crearGato(@RequestBody GatoDto gatoDto) {
        gatoService.crearGato(gatoDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
