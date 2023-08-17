package com.example.library_system.Repository;

import com.example.library_system.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    Book findBookById(Integer id);
    List<Book> findBookByCategory(String category);

    @Query("select b from Book b where b.numberOfPages > 300")
    List<Book> findBookMore300();


    List<Book> findBookByAuthor(String Auther);

    Book searchBookByTitle(String title);
}
