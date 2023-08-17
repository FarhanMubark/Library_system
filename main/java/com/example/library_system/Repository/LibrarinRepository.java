package com.example.library_system.Repository;

import com.example.library_system.Model.Librarian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LibrarinRepository extends JpaRepository<Librarian, Integer> {

    Librarian findLibrarianById(Integer id);

    @Query("select l from Librarian l where l.username=?1 and l.password=?2")
    Librarian findLibrarianByUsernameAndPassword(String username, String password);

//    @Query(" select l from Librarian l where l.email=?1")
//    Librarian findLibrarianByEmail(String email);

    Librarian findLibrarianByEmail(String email);
}
