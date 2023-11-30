package com.argProg40.veterinariaApp.Services.Gato;

import com.argProg40.veterinariaApp.Controller.Response.GatoDto;
import com.argProg40.veterinariaApp.Services.Mappers.GatoMapper;
import com.argProg40.veterinariaApp.Services.Mappers.GatoMapperResponse;
import com.argProg40.veterinariaApp.entidades.Mascota;
import com.argProg40.veterinariaApp.repositories.MascotaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class GatoServiceImpl implements GatoService{
    private final MascotaRepository gatoRepository;
    private final GatoMapper gatoMapper;

    private final GatoMapperResponse gatoMapperResponse;

    public GatoServiceImpl(MascotaRepository gatoRepository, GatoMapper gatoMapper, GatoMapperResponse gatoMapperResponse) {
        this.gatoRepository = gatoRepository;
        this.gatoMapper = gatoMapper;
        this.gatoMapperResponse = gatoMapperResponse;
    }

    // Constructor y otros métodos

    public List<GatoDto> obtenerTodosLosGatos() {
        List<Mascota> gatos = gatoRepository.findAllGato();
        return gatos.stream()
                .map(gatoMapperResponse)
                .toList()
                .stream()
                .map(gatoMapper)
                .toList();
    }

    public GatoDto obtenerGatoPorId(Long id) {
        Mascota gato =  gatoRepository.findById(id).orElse(null);
        assert gato != null;
        if(Objects.equals(gato.getTipo(), "Gato")) return gatoMapper.apply(gatoMapperResponse.apply(gato));
        return null;
    }

    public void crearGato(GatoDto gatoDto) {
        Mascota gato = new Mascota();
        gato.setNombre(gatoDto.getNombre());
        gato.setTipo("Gato");
        gato.setColor(gatoDto.getColor());
        gato.setEdad(gatoDto.getEdad());
        gatoRepository.save(gato);
    }

    // Otros métodos para actualizar y eliminar gatos
}
