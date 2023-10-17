package com.ajith.bookservice.service;

import com.ajith.bookservice.model.Book;
import com.ajith.bookservice.repo.BookRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepo bookRepo;
    Logger logger = LoggerFactory.getLogger(BookService.class);

    public List<Book> getAllBooks(){
        List<Book> books = bookRepo.findAll();
        logger.info("Getting AllBooks: {}",books);
        return books;
    }
    public Book getBook(int id){
        Book book = bookRepo.findById(id).get();
        logger.info("Exception in fetching book: {}",book);
        return book;
    }

    public Book addBook(Book book){
        return bookRepo.save(book);
    }
    public String removeBook(int id){
        bookRepo.deleteById(id);
        return "Book delete by id: "+id;
    }
    public Book updateBook(int id, Book book){
        Book existingBook = bookRepo.findById(id).get();
        existingBook.setName(book.getName()!=null && book.getName().length()>0?book.getName(): existingBook.getName());
        existingBook.setType(book.getType()!=null && book.getType().length()>0?book.getType():existingBook.getType());
        existingBook.setAuthor(book.getAuthor()!=null && book.getAuthor().length()>0?book.getAuthor(): existingBook.getAuthor());
        existingBook.setAvailable(book.getAvailable()!=null && book.getAvailable().length()>0?book.getAvailable():existingBook.getAvailable());
        Book updatedBook = bookRepo.save(existingBook);
        logger.info("Updation: {}",updatedBook);
        return updatedBook;
    }
    public List<Book> availableBooks(){
        List<Book> availableBooks = bookRepo.findAvailableBooks();
        logger.info("Available books: {}",availableBooks);
        return availableBooks;
    }
}
