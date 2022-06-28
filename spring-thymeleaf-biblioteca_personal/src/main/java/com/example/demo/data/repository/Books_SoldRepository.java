package com.example.demo.data.repository;

import com.example.demo.data.entity.Books_Read;
import com.example.demo.data.entity.Books_Sold;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Books_SoldRepository extends JpaRepository<Books_Sold, Integer> {
    Page<Books_Sold> findBooks_SoldbyId(Integer userId, Pageable pageable);
}
