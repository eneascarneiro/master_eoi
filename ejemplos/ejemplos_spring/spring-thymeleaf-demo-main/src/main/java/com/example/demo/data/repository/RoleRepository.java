package com.example.demo.data.repository;

import com.example.demo.data.entity.Role;
import com.example.demo.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
