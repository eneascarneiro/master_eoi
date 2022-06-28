package com.example.demo.data.repository;

import com.example.demo.data.entity.Books;
import com.example.demo.data.entity.Books_Read;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Books_ReadRepository extends JpaRepository<Books_Read, Integer> {
    Page<Books_Read> findBooks_ReadbyId(Integer userId, Pageable pageable);
}
