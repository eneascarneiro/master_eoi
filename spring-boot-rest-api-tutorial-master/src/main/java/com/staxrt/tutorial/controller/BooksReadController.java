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
import com.staxrt.tutorial.model.BooksRead;
import com.staxrt.tutorial.model.User;
import com.staxrt.tutorial.repository.BooksReadRepository;
import com.staxrt.tutorial.repository.UserRepository;
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
public class BooksReadController {

  @Autowired
  private BooksReadRepository booksReadRepository;

  /**
   * Get all users list.
   *
   * @return the list
   */
  @GetMapping("/booksread")
  public List<BooksRead> getAllUsers() {
    return booksReadRepository.findAll();
  }

  /**
   * Gets users by id.
   *
   * @param userId the user id
   * @return the users by id
   * @throws ResourceNotFoundException the resource not found exception
   */
  @GetMapping("/booksread/{id}")
  public ResponseEntity<BooksRead> getUsersById(@PathVariable(value = "id") Long booksReadId)
      throws ResourceNotFoundException {
    BooksRead booksRead =
            booksReadRepository
            .findById(booksReadId)
            .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + booksReadId));
    return ResponseEntity.ok().body(booksRead);
  }

  /**
   * Create user user.
   *
   * @param user the user
   * @return the user
   */
  @PostMapping("/booksRead")
  public BooksRead createBooksread(@Valid @RequestBody BooksRead booksRead) {
        return booksReadRepository.save(booksRead);
  }

  /**
   * Update user response entity.
   *
   * @param userId the user id
   * @param userDetails the user details
   * @return the response entity
   * @throws ResourceNotFoundException the resource not found exception
   */
  @PutMapping("/booksRead/{id}")
  public ResponseEntity<BooksRead> updateBooksRead(
      @PathVariable(value = "id") Long booksReadId, @Valid @RequestBody BooksRead userDetails)
      throws ResourceNotFoundException {

    BooksRead booksRead =
            booksReadRepository
            .findById(booksReadId)
            .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + booksReadId));

    booksRead.setFechaLectura (userDetails.getFechaLectura());


    final BooksRead updatedUser = booksReadRepository.save(booksRead);
    return ResponseEntity.ok(updatedUser);
  }

  /**
   * Delete user map.
   *
   * @param userId the user id
   * @return the map
   * @throws Exception the exception
   */
  @DeleteMapping("/booksRead/{id}")
  public Map<String, Boolean> deleteBooksRead(@PathVariable(value = "id") Long booksReadId) throws Exception {
    BooksRead booksRead  =
            booksReadRepository
            .findById(booksReadId)
            .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + booksReadId));

    booksReadRepository.delete(booksRead);
    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", Boolean.TRUE);
    return response;
  }
}
