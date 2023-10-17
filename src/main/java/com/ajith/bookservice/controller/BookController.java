package com.ajith.bookservice.controller;

import com.ajith.bookservice.model.Book;
import com.ajith.bookservice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;
    @GetMapping("/all")
    public ResponseEntity<List<Book>> getAllBooks(){
        return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
    }
    @GetMapping("/available")
    public ResponseEntity<List<Book>> getAllAvailableBooks(){
        return new ResponseEntity<>(bookService.availableBooks(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@PathVariable int id){
        return new ResponseEntity<>(bookService.getBook(id),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeBook(@PathVariable int id){
        return new ResponseEntity<>(bookService.removeBook(id),HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable int id, @RequestBody Book book){
        return new ResponseEntity<>(bookService.updateBook(id,book),HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Book> addBook(@RequestBody Book book){
        return new ResponseEntity<>(bookService.addBook(book),HttpStatus.CREATED);
    }
}
