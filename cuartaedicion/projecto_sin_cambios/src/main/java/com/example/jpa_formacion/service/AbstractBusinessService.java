package com.example.jpa_formacion.service;

import com.example.jpa_formacion.dto.UsuarioDto;
import com.example.jpa_formacion.model.Usuario;
import com.example.jpa_formacion.service.mapper.AbstractServiceMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public abstract class AbstractBusinessService <E, ID, DTO,  REPO extends JpaRepository<E,ID> ,
        MAPPER extends AbstractServiceMapper<E,DTO>>  {
    private final REPO repo;
    private final MAPPER serviceMapper;


    protected AbstractBusinessService(REPO repo, MAPPER mapper) {
        this.repo = repo;
        this.serviceMapper = mapper;
    }
    //Buscamos por id
    public Optional<E> buscar(ID id){return  this.repo.findById(id);}
    //Lista de todos los DTOs buscarTodos devolvera lista y paginas
    public List<DTO> buscarTodos(){
        return  this.serviceMapper.toDto(this.repo.findAll());
    }

    public List<E> buscarEntidades(){
        return  this.repo.findAll();
    }
    public Set<E> buscarEntidadesSet(){
        Set<E> eSet = new HashSet<E>(this.repo.findAll());
        return  eSet;
    }

    public Set<DTO> buscarTodosSet(){
        Set<DTO> dtos = new HashSet<DTO>(this.serviceMapper.toDto(this.repo.findAll()));
        return  dtos;
    }

    public Page<DTO> buscarTodos(Pageable pageable){
        return  repo.findAll(pageable).map(this.serviceMapper::toDto);
    }

    //Buscar por id
    public Optional<DTO> encuentraPorId(ID id){

        return this.repo.findById(id).map(this.serviceMapper::toDto);
    }
    public Optional<E> encuentraPorIdEntity(ID id){

        return this.repo.findById(id);
    }
    //Guardar
    public DTO guardar(DTO dto) throws Exception {
        //Traduzco del dto con datos de entrada a la entidad
        final E entidad = serviceMapper.toEntity(dto);
        //Guardo el la base de datos
        E entidadGuardada =  repo.save(entidad);
        //Traducir la entidad a DTO para devolver el DTO
        return serviceMapper.toDto(entidadGuardada);
    }
    //Guardar
    public DTO guardarEntidadDto(E entidad)  {
        //Guardo el la base de datos
        E entidadGuardada =  repo.save(entidad);
        //Traducir la entidad a DTO para devolver el DTO
        return serviceMapper.toDto(entidadGuardada);
    }
    //Guardar
    public E guardarEntidadEntidad(E entidad) throws Exception {
        //Guardo el la base de datos
        E entidadGuardada =  repo.save(entidad);
        //Traducir la entidad a DTO para devolver el DTO
        return entidadGuardada;
    }
    public void  guardar(List<DTO> dtos) throws Exception {
        Iterator<DTO> it = dtos.iterator();

        // mientras al iterador queda proximo juego
        while(it.hasNext()){
            //Obtenemos la password de a entidad
            //Datos del usuario
            E e = serviceMapper.toEntity(it.next());
            repo.save(e);
        }
    }
    //eliminar un registro
    public void eliminarPorId(ID id){
        this.repo.deleteById(id);
    }
    //Obtener el mapper
    public MAPPER getMapper(){return  serviceMapper;}
    //Obtener el repo
    public REPO getRepo(){return  repo;}
}
