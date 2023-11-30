package com.argProg40.veterinariaApp.Services.Mappers;

import com.argProg40.veterinariaApp.Controller.Response.MedicoDto;
import com.argProg40.veterinariaApp.entidades.Medico;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class MedicoMapper implements Function<Medico, MedicoDto> {

    @Override
    public MedicoDto apply(Medico medico) {
        return new MedicoDto(
                medico.getId(),
                medico.getNombre()
                // Otros atributos de Medico según sea necesario
        );
    }
}
