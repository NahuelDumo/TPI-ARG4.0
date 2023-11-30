package com.argProg40.veterinariaApp.Services.Medico;

import com.argProg40.veterinariaApp.Controller.Request.MedicoRequestDto;
import com.argProg40.veterinariaApp.Controller.Response.MedicoDto;
import com.argProg40.veterinariaApp.Services.Mappers.MedicoMapper;
import com.argProg40.veterinariaApp.entidades.Medico;
import com.argProg40.veterinariaApp.repositories.MedicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicoServiceImpl implements MedicoService{
    private final MedicoRepository medicoRepository;
    private final MedicoMapper medicoMapper;

    public MedicoServiceImpl(MedicoRepository medicoRepository, MedicoMapper medicoMapper) {
        this.medicoRepository = medicoRepository;
        this.medicoMapper = medicoMapper;
    }

    // Constructor y otros métodos

    public List<MedicoDto> obtenerTodosLosMedicos() {
        List<Medico> medicos = medicoRepository.findAll();
        return medicos.stream()
                .map(medicoMapper::apply)
                .collect(Collectors.toList());
    }

    public MedicoDto obtenerMedicoPorId(Long id) {
        Medico medico = medicoRepository.findById(id).orElse(null);
        return medico != null ? medicoMapper.apply(medico) : null;
    }

    public void crearMedico(MedicoRequestDto medicoDto) {
        Medico medico = new Medico();
        medico.setNombre(medicoDto.getNombre());
        medicoRepository.save(medico);
    }

    // Otros métodos para actualizar y eliminar medicos
}

