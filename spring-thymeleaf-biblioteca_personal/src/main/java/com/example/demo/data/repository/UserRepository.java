package com.example.demo.data.repository;

import com.example.demo.data.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUserNameAndActiveTrue(String username);

    User findByUserName(String username);
    Page<User> findAll(Pageable pageable);
}
