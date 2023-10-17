package com.ajith.bookservice.repo;

import com.ajith.bookservice.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<Book, Integer> {
    @Query(value = "SELECT * FROM books b WHERE b.available=\"true\"", nativeQuery = true)
    List<Book> findAvailableBooks();
}
