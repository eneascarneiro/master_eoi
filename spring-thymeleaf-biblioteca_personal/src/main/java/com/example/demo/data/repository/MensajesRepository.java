package com.example.demo.data.repository;

import com.example.demo.data.entity.BooksRead;
import com.example.demo.data.entity.Mensajes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MensajesRepository extends JpaRepository<Mensajes, Integer> {
    Page<Mensajes> findByUserId(Integer userId, Pageable pageable);
}
