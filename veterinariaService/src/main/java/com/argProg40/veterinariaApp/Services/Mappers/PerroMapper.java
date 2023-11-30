package com.argProg40.veterinariaApp.Services.Mappers;

import com.argProg40.veterinariaApp.Controller.Response.PerroDto;
import com.argProg40.veterinariaApp.entidades.Perro;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class PerroMapper implements Function<Perro, PerroDto> {

    @Override
    public PerroDto apply(Perro perro) {
        return new PerroDto(
                Math.toIntExact(perro.getId()),
                perro.getNombre(),
                perro.getRaza()
        );
    }
}
