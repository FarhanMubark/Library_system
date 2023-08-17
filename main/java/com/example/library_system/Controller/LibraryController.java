package com.example.library_system.Controller;

import com.example.library_system.Api.ApiResponse;

import com.example.library_system.Model.Librarian;
import com.example.library_system.Service.LibrarinService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/libaraian")
@RequiredArgsConstructor
public class LibraryController {




    final private LibrarinService librarinService;

    @GetMapping("/get")
    public ResponseEntity getall(){
        return ResponseEntity.status(200).body(librarinService.getall());
    }

    @PostMapping("/add")
    public ResponseEntity addlib(@RequestBody @Valid Librarian librarian){
        librarinService.add(librarian);
        return ResponseEntity.status(200).body(new ApiResponse("Librarian Added"));
    }

    @PutMapping("/check/{username}/{password}")
    public ResponseEntity checkLogin(@PathVariable String username, @PathVariable String password){
       librarinService.checkLogin(username, password);
        return ResponseEntity.status(200).body(new ApiResponse("User login"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updatelib(@PathVariable int id, @RequestBody @Valid Librarian librarian){
        librarinService.updatelibrarian(id,librarian);
        return ResponseEntity.status(200).body(new ApiResponse("librarian updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deletelab(int id){
        librarinService.deleteLib(id);
        return ResponseEntity.status(200).body(new ApiResponse("librarian deleted"));
    }

    @GetMapping("/getby-email")
    public ResponseEntity getbyEmail(@PathVariable String email){
        Librarian librarian = librarinService.searchByEmail(email);
        return ResponseEntity.status(200).body(librarian);
    }

}
