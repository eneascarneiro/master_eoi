package com.jma.prolecto_sin_cambios_yml.repository;


import com.jma.prolecto_sin_cambios_yml.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {

    @Query("Select count(id) from Usuario where email= ?1 and password = ?2")
    Integer repValidarPassword(String email, String password);

    Usuario findUsuarioByNombreUsuarioIs(String name);
    Usuario findByEmailAndActiveTrue(String name);

    Optional<Usuario> findByEmailAndTokenAndActiveTrue(String name, String token);

    Usuario findByNombreUsuarioAndActiveTrue(String name);


    Usuario findUsuarioByEmailAndActiveTrue(String email);
    Usuario findUsuarioByEmailAndPassword(String email, String password);
    //Definir metodo aparte
}
