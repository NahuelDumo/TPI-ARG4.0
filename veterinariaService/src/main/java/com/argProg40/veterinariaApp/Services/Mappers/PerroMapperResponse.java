package com.argProg40.veterinariaApp.Services.Mappers;

import com.argProg40.veterinariaApp.entidades.Mascota;
import com.argProg40.veterinariaApp.entidades.Perro;
import org.springframework.stereotype.Service;

import java.util.function.Function;
@Service

public class PerroMapperResponse implements Function<Mascota, Perro> {
        @Override
        public Perro apply(Mascota perro) {
            Perro perro1 = new Perro(
                    perro.getRaza()
            );
            perro1.setId(perro.getId());
            perro1.setNombre(perro.getNombre());
            perro1.setRaza(perro.getRaza());
            return perro1;
        }

}
