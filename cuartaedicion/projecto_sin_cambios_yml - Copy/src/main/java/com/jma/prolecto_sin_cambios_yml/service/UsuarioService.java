package com.jma.prolecto_sin_cambios_yml.service;

import com.jma.prolecto_sin_cambios_yml.dto.UsuarioDto;

import com.jma.prolecto_sin_cambios_yml.dto.UsuarioDtoPsw;
import com.jma.prolecto_sin_cambios_yml.model.Usuario;
import com.jma.prolecto_sin_cambios_yml.repository.UsuarioRepository;
import com.jma.prolecto_sin_cambios_yml.service.mapper.UsuarioMapper;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;


@Service
public class UsuarioService   extends AbstractBusinessService<Usuario,Integer,UsuarioDto,
        UsuarioRepository, UsuarioMapper>   {
    //


    //Acceso a los datos de la bbdd
    public UsuarioService(UsuarioRepository repo, UsuarioMapper serviceMapper) {

        super(repo, serviceMapper);
    }
    public UsuarioDto guardar(UsuarioDto usuarioDto, String password){
        System.out.println("usuarioDto:" +usuarioDto.getNombreUsuario() );
        //Traduzco del dto con datos de entrada a la entidad
        final Usuario entidad = getMapper().toEntity(usuarioDto);
        System.out.println("Entidad:" +entidad.getNombreUsuario() );
        entidad.setPassword(password);
        System.out.println("Entidad:" +entidad.getPassword() );
        //Guardo el la base de datos
        Usuario entidadGuardada =  getRepo().save(entidad);
        //Traducir la entidad a DTO para devolver el DTO
        return getMapper().toDto(entidadGuardada);
    }
    public UsuarioDto guardar(UsuarioDtoPsw usuarioDtoPsw){
        System.out.println("usuarioDto:" +usuarioDtoPsw.getNombreUsuario() );
        //Traduzco del dto con datos de entrada a la entidad
        final Usuario entidad = getMapper().toEntityPsw(usuarioDtoPsw);
        System.out.println("Entidad:" +entidad.getNombreUsuario() );
        //Guardo el la base de datos
        Usuario entidadGuardada =  getRepo().save(entidad);
        //Traducir la entidad a DTO para devolver el DTO
        return getMapper().toDto(entidadGuardada);
    }
    //Método para guardar una lista de usuarios
    //La entrada es una lista de DTO ( que viene de la pantalla)
    //La respuesta tipo void
    @Override
    public void  guardar(List<UsuarioDto> lUsuarioDto){
        Iterator<UsuarioDto> it = lUsuarioDto.iterator();

        // mientras al iterador queda proximo juego
        while(it.hasNext()){
            //Obtenemos la password de a entidad
            //Datos del usuario
            Usuario usuario = getMapper().toEntity(it.next());
            usuario.setPassword(getRepo().getReferenceById((int) usuario.getId()).getPassword());
            getRepo().save(usuario);
        }
    }


}
