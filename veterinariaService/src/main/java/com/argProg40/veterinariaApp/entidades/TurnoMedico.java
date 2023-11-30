package com.argProg40.veterinariaApp.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Turnomedico")
public class TurnoMedico {
    @Id
    @GeneratedValue(generator = "Turnomedico")
    @TableGenerator(name = "Turnomedico", table = "sqlite_sequence",
            pkColumnName = "name", valueColumnName = "seq",
            pkColumnValue="Turnomedico",
            initialValue = 0,allocationSize=1)
    @Column(name = "id")
    private Long Id;

    @OneToOne
    @JoinColumn(name = "mascota_id")
    private Mascota mascota;

    @OneToOne
    @JoinColumn(name = "medico_id")
    private Medico medico;

    private Float monto;

    @Column(name = "Fechaturno")
    private LocalDate fechaTurno;
    private boolean aprobado;

    public TurnoMedico(Mascota byId, Medico byId1, Float monto, LocalDate fechaTurno, boolean b) {
        setMascota(byId);
        setMedico(byId1);
        setMonto(monto);
        setFechaTurno(fechaTurno);
        setAprobado(b);
    }

    // Getters y setters
}
