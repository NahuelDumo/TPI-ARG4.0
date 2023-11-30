package com.argProg40.veterinariaApp.repositories;


import com.argProg40.veterinariaApp.entidades.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MascotaRepository extends JpaRepository<Mascota, Long> {
    @Query("SELECT p FROM Mascota p WHERE LOWER(p.tipo) = 'perro'")
    List<Mascota> findAllPerro();

    @Query("SELECT g FROM Mascota g WHERE LOWER(g.tipo) = 'gato'")
    List<Mascota> findAllGato();

}
