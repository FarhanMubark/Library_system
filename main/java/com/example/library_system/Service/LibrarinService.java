package com.example.library_system.Service;

import com.example.library_system.Api.ApiException;
import com.example.library_system.Model.Librarian;
import com.example.library_system.Repository.LibrarinRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LibrarinService {
    final private LibrarinRepository librarinRepository;

    public List<Librarian> getall(){
      return  librarinRepository.findAll();
    }

    public void add(Librarian librarian){
        librarinRepository.save(librarian);
    }




    public void updatelibrarian(Integer id, Librarian librarian){
        Librarian librarian1 = librarinRepository.findLibrarianById(id);

        if (librarian1 ==null){
            throw new ApiException("Id not found");
        }

        librarian1.setName(librarian.getName());
        librarian1.setEmail(librarian.getEmail());
        librarian1.setUsername(librarian.getUsername());
        librarian1.setPassword(librarian.getPassword());
        librarinRepository.save(librarian1);
       
    }

    public void deleteLib(Integer id){
        Librarian librarian1 = librarinRepository.findLibrarianById(id);
        if (librarian1 ==null){
            throw new ApiException("Id not found");
        }

        librarinRepository.delete(librarian1);
    }

    public Librarian getLibById(Integer id){
        Librarian librarian1 = librarinRepository.findLibrarianById(id);
        if (librarian1 ==null){
            throw new ApiException("Id not found");
        }

        return librarian1;
    }

    public void checkLogin(String username, String password){
        Librarian librarian1 = librarinRepository.findLibrarianByUsernameAndPassword(username, password);

        if (librarian1==null){
            throw new ApiException("User not found");
        }

        librarinRepository.save(librarian1);

    }

    public Librarian searchByEmail(String email){
        Librarian librarian1 = librarinRepository.findLibrarianByEmail(email);
        if (librarian1 ==null){
            throw new ApiException("account not found");
        }
        return librarian1;
    }

}
