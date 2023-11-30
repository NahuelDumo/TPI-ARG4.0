package com.argProg40.veterinariaApp.Services.Medico;

import com.argProg40.veterinariaApp.Controller.Request.MedicoRequestDto;
import com.argProg40.veterinariaApp.Controller.Response.MedicoDto;

import java.util.List;

public interface MedicoService {

    List<MedicoDto> obtenerTodosLosMedicos();

    MedicoDto obtenerMedicoPorId(Long id);

    void crearMedico(MedicoRequestDto medicoDto);

    // Otros métodos para actualizar y eliminar medicos
}
