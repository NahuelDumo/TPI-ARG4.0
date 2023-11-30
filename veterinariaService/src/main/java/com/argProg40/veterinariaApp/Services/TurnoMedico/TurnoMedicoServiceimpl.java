package com.argProg40.veterinariaApp.Services.TurnoMedico;

import com.argProg40.veterinariaApp.Controller.Response.TurnoMedicoDto;
import com.argProg40.veterinariaApp.Services.Mappers.TurnoMedicoMapper;
import com.argProg40.veterinariaApp.entidades.TurnoMedico;
import com.argProg40.veterinariaApp.repositories.MascotaRepository;
import com.argProg40.veterinariaApp.repositories.MedicoRepository;
import com.argProg40.veterinariaApp.repositories.TurnoMedicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurnoMedicoServiceimpl implements TurnoMedicoService{
    private final TurnoMedicoRepository turnoMedicoRepository;

    private final MascotaRepository mascotaRepository;

    private final MedicoRepository medicoRepository;

    private final TurnoMedicoMapper turnoMedicoMapper;

    public TurnoMedicoServiceimpl(TurnoMedicoRepository turnoMedicoRepository, MascotaRepository mascotaRepository, MedicoRepository medicoRepository, TurnoMedicoMapper turnoMedicoMapper) {
        this.turnoMedicoRepository = turnoMedicoRepository;
        this.mascotaRepository = mascotaRepository;
        this.medicoRepository = medicoRepository;
        this.turnoMedicoMapper = turnoMedicoMapper;
    }

    // Constructor y otros métodos

    public List<TurnoMedicoDto> obtenerTodosLosTurnos() {
        List<TurnoMedico> turnosMedicos = turnoMedicoRepository.findAll();
        return turnosMedicos.stream()
                .map(turnoMedicoMapper::apply)
                .toList();
    }

    public TurnoMedicoDto obtenerTurnoPorId(Long id) {
        TurnoMedico turnoMedico = turnoMedicoRepository.findById(id).orElse(null);
        return turnoMedico != null ? turnoMedicoMapper.apply(turnoMedico) : null;
    }

    public void crearTurno(TurnoMedicoDto turnoMedicoDto) {
        TurnoMedico turnoMedico = new TurnoMedico(
                mascotaRepository.getById(turnoMedicoDto.getMascotaId()),
                medicoRepository.getById(turnoMedicoDto.getMedicoId().longValue()),
                turnoMedicoDto.getMonto(),
                turnoMedicoDto.getFechaTurno(),
                false
                );
        turnoMedicoRepository.save(turnoMedico);
    }



    @Override
    public void AprobarTurno(int IdTurno){
        TurnoMedico turnoMedico = turnoMedicoRepository.findById(Long.valueOf(IdTurno)).orElse(null);
        if(turnoMedico != null) {
            turnoMedico.setAprobado(true);
            turnoMedicoRepository.save(turnoMedico);
        }

    }

    @Override
    public List<TurnoMedicoDto> obtenerTodosLosTurnosMedico(Long id) {
        List<TurnoMedico> list =  turnoMedicoRepository.findTurnosByMedicoId(id);
        return list.stream()
                .map(turnoMedicoMapper)
                .toList();
    }


    // Otros métodos para actualizar y eliminar turnos
}

