package com.example.jpa_formacion.repository;


import com.example.jpa_formacion.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {

    @Query("Select count(id) from Usuario where email= ?1 and password = ?2")
    Integer repValidarPassword(String email, String password);

    Usuario findUsuarioByNombreUsuarioIs(String name);
    Usuario findByEmailAndActiveTrue(String name);

    Usuario findByNombreUsuarioAndActiveTrue(String name);


    Usuario findUsuarioByEmailAndActiveTrue(String email);
    Usuario findUsuarioByEmailAndPassword(String email, String password);
    //Definir metodo aparte
}
