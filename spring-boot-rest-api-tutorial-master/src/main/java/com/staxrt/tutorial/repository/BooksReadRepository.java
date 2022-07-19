package com.staxrt.tutorial.repository;

import com.staxrt.tutorial.model.BooksRead;
import com.staxrt.tutorial.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface User repository.
 *
 * @author Givantha Kalansuriya
 */
@Repository
public interface BooksReadRepository extends JpaRepository<BooksRead, Long> {}
