package com.jma.prolecto_sin_cambios_yml.service.mapper;

import com.jma.prolecto_sin_cambios_yml.dto.GaleriaDto;
import com.jma.prolecto_sin_cambios_yml.model.Empleado;
import com.jma.prolecto_sin_cambios_yml.model.Galeria;
import com.jma.prolecto_sin_cambios_yml.service.EmpleadoService;
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
