package com.argProg40.veterinariaApp.repositories;


import com.argProg40.veterinariaApp.Controller.Response.TurnoMedicoDto;
import com.argProg40.veterinariaApp.entidades.TurnoMedico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TurnoMedicoRepository extends JpaRepository<TurnoMedico, Long> {
    List<TurnoMedicoDto> findByMascotaId(Long mascotaId);

    @Query("SELECT t FROM TurnoMedico t WHERE t.medico.id = :id")
    List<TurnoMedico> findTurnosByMedicoId(@Param("id") Long id);
}