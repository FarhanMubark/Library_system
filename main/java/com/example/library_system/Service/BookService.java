package com.example.library_system.Service;

import com.example.library_system.Api.ApiExeption;
import com.example.library_system.Model.Book;
import com.example.library_system.Repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public void addBook(Book book){
        bookRepository.save(book);
    }

    public void updateBook(Integer id, Book book){
        Book book1 = bookRepository.findBookById(id);
        if (book1==null){
            throw new ApiExeption("Id not found");
        }
        book1.setTitle(book.getTitle());
        book1.setCategory(book.getCategory());
        book1.setISBN(book.getISBN());
        book1.setNumberOfPages(book.getNumberOfPages());
        bookRepository.save(book1);
    }

    public void deleteBook(Integer id){
        Book book1 = bookRepository.findBookById(id);

        if (book1==null){
            throw new ApiExeption("Id not found");
        }
        bookRepository.delete(book1);
    }

    public List<Book> findByCategory(String category){
        List<Book> books = bookRepository.findBookByCategory(category);

        if (category==null){
            throw new ApiExeption("is Empty");
        }

        return books;
    }

    public List<Book> getBookMore300(){
        return bookRepository.findBookMore300();
    }

    public List<Book> getBooksbyAuther(String auther){
        List<Book> books = bookRepository.findBookByAuthor(auther);

        if (books==null){
            throw new ApiExeption("Author not found");
        }

        return books;
    }

    public Book getBookbyTitle(String title){
        Book book1 = bookRepository.searchBookByTitle(title);

        if (book1==null){
            throw new ApiExeption("Title Not found");
        }

        return book1;

    }
}
