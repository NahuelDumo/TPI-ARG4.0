package com.argProg40.veterinariaApp.Controller.Response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TurnoMedicoDto {
    private Long mascotaId;
    private Long medicoId;
    private Float monto;
    private LocalDate fechaTurno;

}

