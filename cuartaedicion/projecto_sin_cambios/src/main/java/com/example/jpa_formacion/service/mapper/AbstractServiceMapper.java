package com.example.jpa_formacion.service.mapper;

import org.modelmapper.ModelMapper;

import java.util.*;
import java.util.stream.Collectors;

public abstract class AbstractServiceMapper<E,DTO> {
    //Convertir de entidad a dto
    public abstract DTO toDto(E e);
    //Convertir de dto a entidad
    public abstract E toEntity(DTO dto) throws Exception;

    //Conversion de listas de dtos a entidades
    public List<E>  toEntity(List<DTO> dtos) throws Exception {
        //Recorrer la lista manualmente para gestional las excepciopnes
        ListIterator it = dtos.listIterator();
        List<E> list = new ArrayList<>();
        while (it.hasNext()){
            DTO dto = (DTO) it.next();
            E e = this.toEntity(dto);
            list.add(e);
        }
        return list;
    }
    //Conversion de listas de entidades a DTOs
    public List<DTO>  toDto(List<E> e){
        return e.stream().map(this::toDto).collect(Collectors.toList());
    }

    //Gestionamos set de datos
    public Set<E> toEntity(Set<DTO> dtos) throws Exception {
        //return dtos.stream().map(this::toEntity).collect(Collectors.toSet());
        Set<E> eSet = new HashSet<E>();
        for (DTO item: dtos) {
            E e = this.toEntity(item);
            eSet.add(e);
        }
        return  eSet;
    }
    //Conversion de listas de entidades a DTOs
    public Set<DTO>  toDto(Set<E> e){
        return e.stream().map(this::toDto).collect(Collectors.toSet());
    }
}
