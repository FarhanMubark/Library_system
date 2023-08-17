package com.example.library_system.Controller;

import com.example.library_system.Api.ApiResponse;
import com.example.library_system.Model.Book;
import com.example.library_system.Service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/book")
@RequiredArgsConstructor
public class BookController {
    final private BookService bookService;

    @GetMapping("/get")
    public ResponseEntity getAll(){
        return ResponseEntity.status(200).body(bookService.getAllBooks());
    }

    @PostMapping("/add")
    public ResponseEntity addbook(@RequestBody @Valid Book book){
        bookService.addBook(book);
        return ResponseEntity.status(200).body(new ApiResponse("Book add"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateBook(@PathVariable int id, @RequestBody @Valid Book book){
        bookService.updateBook(id, book);
        return ResponseEntity.status(200).body(new ApiResponse("Book Updated!"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteBook(@PathVariable int id){
        bookService.deleteBook(id);
        return ResponseEntity.status(200).body(new ApiResponse("Deleted !"));
    }

    @GetMapping("/getby-category/{category}")
    public ResponseEntity findbooksBycategory(@PathVariable String category){
        List<Book> bookList = bookService.findByCategory(category);
        return ResponseEntity.status(200).body(bookList);
    }

    @GetMapping("/get-more300")
    public ResponseEntity getMore300Page(){
        return ResponseEntity.status(200).body(bookService.getBookMore300());
    }

    @GetMapping("/getby-title/{title}")
    public ResponseEntity getBookBytitle(@PathVariable String title){
        Book book1 = bookService.getBookbyTitle(title);
        return ResponseEntity.status(200).body(book1);
    }
}
