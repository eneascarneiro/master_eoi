/*
 *
 *  Copyright (c) 2018-2020 Givantha Kalansuriya, This source is a part of
 *   Staxrt - sample application source code.
 *   http://staxrt.com
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 */

package com.staxrt.tutorial.controller;

import com.staxrt.tutorial.exception.ResourceNotFoundException;
import com.staxrt.tutorial.model.Books;
import com.staxrt.tutorial.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The type User controller.
 *
 * @author Givantha Kalansuriya
 */
@RestController
@RequestMapping("/api/v1")
public class BooksController {

  @Autowired
  private BooksRepository booksRepository;

  /**
   * Get all users list.
   *
   * @return the list
   */
  @GetMapping("/Books")
  public List<Books> getAllUsers() {
    return booksRepository.findAll();
  }

  /**
   * Gets users by id.
   *
   * @param userId the user id
   * @return the users by id
   * @throws ResourceNotFoundException the resource not found exception
   */
  @GetMapping("/Books/{id}")
  public ResponseEntity<Books> getUsersById(@PathVariable(value = "id") Long booksId)
      throws ResourceNotFoundException {
    Books books =
            booksRepository
            .findById(booksId)
            .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + booksId));
    return ResponseEntity.ok().body(books);
  }

  /**
   * Create user user.
   *
   * @param user the user
   * @return the user
   */
  @PostMapping("/Books")
  public Books createBooks(@Valid @RequestBody Books books) {
        return booksRepository.save(books);
  }

  /**
   * Update user response entity.
   *
   * @param userId the user id
   * @param userDetails the user details
   * @return the response entity
   * @throws ResourceNotFoundException the resource not found exception
   */
  @PutMapping("/Books/{id}")
  public ResponseEntity<Books> updateBooks(
      @PathVariable(value = "id") Integer booksId, @Valid @RequestBody Books userDetails)
      throws ResourceNotFoundException {

    Books Books =
            booksRepository
            .findById(booksId)
            .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + booksId));

    Books.setBooktitle (userDetails.getBooktitle());


    final Books updatedUser = booksRepository.save(Books);
    return ResponseEntity.ok(updatedUser);
  }

  /**
   * Delete user map.
   *
   * @param userId the user id
   * @return the map
   * @throws Exception the exception
   */
  @DeleteMapping("/Books/{id}")
  public Map<String, Boolean> deleteBooks(@PathVariable(value = "id") Long booksId) throws Exception {
    Books books  =
            booksRepository
            .findById(booksId)
            .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + booksId));

    booksRepository.delete(books);
    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", Boolean.TRUE);
    return response;
  }
}
