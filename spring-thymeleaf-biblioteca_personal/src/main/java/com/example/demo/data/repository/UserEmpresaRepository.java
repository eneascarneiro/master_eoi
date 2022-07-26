package com.example.demo.data.repository;

import com.example.demo.data.entity.UserEmpresa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserEmpresaRepository extends JpaRepository<UserEmpresa, Integer> {
    Page<UserEmpresa> findAll(Pageable pageable);
    Page<UserEmpresa> findByUserId(Integer userId,Pageable pageable);
}
