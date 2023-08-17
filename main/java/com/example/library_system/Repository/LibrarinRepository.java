package com.example.library_system.Repository;

import com.example.library_system.Model.Librarian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibrarinRepository extends JpaRepository<Librarian, Integer> {

    Librarian findLibrarianById(Integer id);

    Librarian findLibrarianByUsernameAndPassword(String username, String password);


}
