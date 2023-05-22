package com.example.jpa_formacion.service.mapper;

import com.example.jpa_formacion.dto.GaleriaDto;
import com.example.jpa_formacion.model.Empleado;
import com.example.jpa_formacion.model.Galeria;
import com.example.jpa_formacion.service.EmpleadoService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GaleriaMapper extends AbstractServiceMapper<Galeria, GaleriaDto> {
    //Convertir de entidad a dto
    private final EmpleadoService empleadoService;

    public GaleriaMapper(EmpleadoService empleadoService) {

        this.empleadoService = empleadoService;
    }
    @Override
    public GaleriaDto toDto(Galeria entidad){
        final GaleriaDto dto = new GaleriaDto();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(entidad,dto);
        //Comprobar si hay contenido
        Optional<Empleado> empleado = Optional.ofNullable(entidad.getEmpleadoGaleria());
        if(empleado.isPresent()){
            dto.setEmpleadoId((int)empleado.get().getId());
            dto.setEmpleadoNombre(entidad.getEmpleadoGaleria().getNombre() + " " +
                    entidad.getEmpleadoGaleria().getApellido1());
        }
        else {
            dto.setEmpleadoId(-1);
            dto.setEmpleadoNombre("No informado");
        }
        return dto;
    }
    //Convertir de dto a entidad
    @Override
    public Galeria toEntity(GaleriaDto dto) throws Exception {
        final Galeria entidad = new Galeria();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(dto, entidad);
        Optional<Empleado> empleado = empleadoService.encuentraPorIdEntity(dto.getEmpleadoId());
        //Si lo encuentro continuo si no lanzo una excepcion
        if (empleado.isPresent()) {
            entidad.setEmpleadoGaleria(empleado.get());
        } else {
            throw new Exception("Usuario no encontrado");
        }
        return entidad;
    }
}
