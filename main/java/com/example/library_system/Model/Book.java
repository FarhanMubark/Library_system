package com.example.library_system.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty
    @Column(columnDefinition = "varchar(20) not null unique")
    private String title;
    @Column(columnDefinition = "varchar(20) not null")
    private String Author;
//    Academic or Mystery or Novel
    @Column(columnDefinition = "varchar(20) not null check(category ='Academin' or category = 'Mystery' or category='Novel')")
    private String category;
    @NotNull
    @Column(columnDefinition = "int not null")
    private Integer ISBN;

    @Column(columnDefinition = "int not null check (numberOfPages >=50 )")
    private Integer numberOfPages;
}
