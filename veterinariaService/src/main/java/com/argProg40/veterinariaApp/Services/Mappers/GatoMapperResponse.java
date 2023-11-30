package com.argProg40.veterinariaApp.Services.Mappers;

import com.argProg40.veterinariaApp.entidades.Gato;
import com.argProg40.veterinariaApp.entidades.Mascota;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class GatoMapperResponse implements Function<Mascota, Gato>{
    @Override
    public Gato apply(Mascota gato) {
        Gato gato1 = new Gato(
                gato.getColor(),
                gato.getEdad()
        );
        gato1.setId(gato.getId());
        gato1.setNombre(gato.getNombre());
        return gato1;
    }
}

