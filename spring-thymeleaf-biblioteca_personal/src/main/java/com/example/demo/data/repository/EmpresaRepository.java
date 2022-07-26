package com.example.demo.data.repository;

import com.example.demo.data.entity.Books;
import com.example.demo.data.entity.BooksSold;
import com.example.demo.data.entity.Empresa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {
    Page<Empresa> findAll(Pageable pageable);
}
