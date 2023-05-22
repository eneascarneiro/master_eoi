package com.example.jpa_formacion.repository;



import com.example.jpa_formacion.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
