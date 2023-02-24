package com.example.demo.data.repository;

import com.example.demo.data.entity.Books;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<Books, Integer> {
    Page<Books> findAll(Pageable pageable);
}
