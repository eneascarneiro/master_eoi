package com.jma.prolecto_sin_cambios_yml.service.mapper;

import com.jma.prolecto_sin_cambios_yml.dto.ClienteDto;
import com.jma.prolecto_sin_cambios_yml.model.Cliente;
import com.jma.prolecto_sin_cambios_yml.model.Empleado;
import com.jma.prolecto_sin_cambios_yml.service.EmpleadoService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ClienteMapper extends AbstractServiceMapper<Cliente, ClienteDto> {
    //Convertir de entidad a dto
    private final EmpleadoService empleadoService;

    public ClienteMapper(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }
    @Override
    public ClienteDto toDto(Cliente entidad){
        final ClienteDto dto = new ClienteDto();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(entidad,dto);
        //Comprobar si hay contenido
        Optional<Empleado> empleado = Optional.ofNullable(entidad.getEmpleado());
        if(empleado.isPresent()){
            dto.setEmpleadoId((int)empleado.get().getId());
            dto.setEmpleadoNombre(entidad.getEmpleado().getNombre() + " " +
                    entidad.getEmpleado().getApellido1() + " " +
                    entidad.getEmpleado().getApellido2() + " " );
        }
        else {
            dto.setEmpleadoId(-1);
            dto.setEmpleadoNombre("No informado");
        }
        return dto;
    }
    //Convertir de dto a entidad
    @Override
    public Cliente toEntity(ClienteDto dto) throws Exception {
        System.out.println("ClienteMapper dto emplid:"+ dto.getEmpleadoId() );
        final Cliente entidad = new Cliente();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(dto,entidad);

        Optional<Empleado> empleado = empleadoService.encuentraPorIdEntity(dto.getEmpleadoId());
        //Si lo encuentro continuo si no lanzo una excepcion
        if(empleado.isPresent()){
            entidad.setEmpleado(empleado.get());
        }
        else{
            throw new Exception("Usuario no encontrado");
        }
        return entidad;
    }
}
