package com.staxrt.tutorial.repository;

import com.staxrt.tutorial.model.Books;
import com.staxrt.tutorial.model.BooksRead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * The interface User repository.
 *
 * @author Givantha Kalansuriya
 */
@Repository
public interface BooksRepository extends JpaRepository<Books, Long> {

}
