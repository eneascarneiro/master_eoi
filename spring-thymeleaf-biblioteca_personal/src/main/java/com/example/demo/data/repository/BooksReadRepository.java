package com.example.demo.data.repository;

import com.example.demo.data.entity.BooksRead;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksReadRepository extends JpaRepository<BooksRead, Integer> {
    Page<BooksRead> findByUserId(Integer userId, Pageable pageable);
}
