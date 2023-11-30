package com.argProg40.veterinariaApp.Services.Perro;

import com.argProg40.veterinariaApp.Controller.Response.PerroDto;
import com.argProg40.veterinariaApp.Services.Mappers.PerroMapper;
import com.argProg40.veterinariaApp.Services.Mappers.PerroMapperResponse;
import com.argProg40.veterinariaApp.entidades.Mascota;
import com.argProg40.veterinariaApp.repositories.MascotaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class PerroServiceImpl implements PerroService {
    private final MascotaRepository perroRepository;
    private final PerroMapper perroMapper;

    private final PerroMapperResponse perroMapperResponse;

    public PerroServiceImpl(MascotaRepository perroRepository, PerroMapper perroMapper, PerroMapperResponse perroMapperResponse) {
        this.perroRepository = perroRepository;
        this.perroMapper = perroMapper;
        this.perroMapperResponse = perroMapperResponse;
    }

    // Constructor y otros métodos

    public List<PerroDto> obtenerTodosLosPerros() {
        List<Mascota> perros = perroRepository.findAllPerro();
        return perros.stream()
                .map(perroMapperResponse)
                .toList()
                .stream().
                map(perroMapper)
                .toList();
    }

    public PerroDto obtenerPerroPorId(Long id) {
        Mascota perro = perroRepository.findById(id).orElse(null);
        assert perro != null;
        if(Objects.equals(perro.getTipo(), "Perro")) return perroMapper.apply(perroMapperResponse.apply(perro));
        return null;
    }

    public void crearPerro(PerroDto perroDto) {
        Mascota perro = new Mascota();
        perro.setNombre(perroDto.getNombre());
        perro.setTipo("perro");
        perro.setRaza(perroDto.getRaza());
        perroRepository.save(perro);
    }

}

