package com.app.gestionturnos.repository;


import com.app.gestionturnos.model.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {

    @Query("Select count(id) from Usuario where email= ?1 and password = ?2")
    Integer repValidarPassword(String email, String password);

    Usuario findUsuarioByNombreUsuarioIs(String name);
    Usuario findByEmailAndActiveTrue(String name);

    Usuario findByNombreUsuarioAndActiveTrue(String name);


    Usuario findUsuarioByEmailAndActiveTrue(String email);

    Usuario findUsuarioByEmailAndPassword(String email, String password);

    Page<Usuario> findByEmailContainingIgnoreCase(String keyword , Pageable pageable);
    Page<Usuario> findByNombreUsuarioContainingIgnoreCase(String keyword , Pageable pageable);

    Page<Usuario> findByNombreUsuarioContainingIgnoreCaseAndEmailContainingIgnoreCase(String keywordNombre ,
                                                                                      String keywordemail ,
                                                                                      Pageable pageable);
    //Definir metodo aparte
}
