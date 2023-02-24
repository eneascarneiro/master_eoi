package com.example.demo.data.repository;

import com.example.demo.data.entity.BooksSold;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksSoldRepository extends JpaRepository<BooksSold, Integer> {
    Page<BooksSold> findByUserId(Integer userId, Pageable pageable);
    Page<BooksSold> findAll( Pageable pageable);
}
