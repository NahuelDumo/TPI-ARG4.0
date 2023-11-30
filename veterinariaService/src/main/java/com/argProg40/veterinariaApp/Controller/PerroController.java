package com.argProg40.veterinariaApp.Controller;

import com.argProg40.veterinariaApp.Controller.Response.PerroDto;
import com.argProg40.veterinariaApp.Services.Perro.PerroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/perros")
public class PerroController {
    private final PerroService perroService;

    public PerroController(PerroService perroService) {
        this.perroService = perroService;
    }

    // Constructor y otros métodos

    @GetMapping
    public ResponseEntity<List<PerroDto>> obtenerTodosLosPerros() {
        List<PerroDto> perros = perroService.obtenerTodosLosPerros();
        return new ResponseEntity<>(perros, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PerroDto> obtenerPerroPorId(@PathVariable Long id) {
        PerroDto perro = perroService.obtenerPerroPorId(id);
        return perro != null
                ? new ResponseEntity<>(perro, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Void> crearPerro(@RequestBody PerroDto perroDto) {
        perroService.crearPerro(perroDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}

