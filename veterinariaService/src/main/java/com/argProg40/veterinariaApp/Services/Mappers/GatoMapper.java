package com.argProg40.veterinariaApp.Services.Mappers;


import com.argProg40.veterinariaApp.Controller.Response.GatoDto;
import com.argProg40.veterinariaApp.entidades.Gato;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class GatoMapper implements Function<Gato, GatoDto> {

    @Override
    public GatoDto apply(Gato gato) {
        return new GatoDto(
                Math.toIntExact(gato.getId()),
                gato.getNombre(),
                gato.getColor(),
                gato.getEdad()
        );
    }
}
