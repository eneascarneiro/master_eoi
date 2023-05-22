package com.example.jpa_formacion.service;

import com.example.jpa_formacion.service.mapper.AbstractServiceMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public abstract class AbstractBusinessServiceSoloEnt<E, ID,  REPO extends JpaRepository<E,ID>>  {
    private final REPO repo;



    protected AbstractBusinessServiceSoloEnt(REPO repo) {
        this.repo = repo;

    }

    public List<E> buscarEntidades(){
        return  this.repo.findAll();
    }
    public Set<E> buscarEntidadesSet(){
        Set<E> eSet = new HashSet<E>(this.repo.findAll());
        return  eSet;
    }

    public Optional<E> encuentraPorIdEntity(ID id){

        return this.repo.findById(id);
    }
    public Optional<E> encuentraPorId(ID id){

        return this.repo.findById(id);
    }
    public Page<E> buscarTodos(Pageable pageable){
        return  repo.findAll(pageable);
    }
    public Set<E> buscarTodosSet(){
        Set<E> eSet = new HashSet<E>(this.repo.findAll());
        return  eSet;
    }
    //Guardar
    public E guardar(E entidad) throws Exception {
        //Guardo el la base de datos
        E entidadGuardada =  repo.save(entidad);
        //Traducir la entidad a DTO para devolver el DTO
        return entidadGuardada;
    }
    public void  guardar(List<E> ents ) throws Exception {
        Iterator<E> it = ents.iterator();

        // mientras al iterador queda proximo juego
        while(it.hasNext()){
            //Obtenemos la password de a entidad
            //Datos del usuario
            E e = it.next();
            repo.save(e);
        }
    }
    //eliminar un registro
    public void eliminarPorId(ID id){
        this.repo.deleteById(id);
    }
    //Obtener el repo
    public REPO getRepo(){return  repo;}
}
