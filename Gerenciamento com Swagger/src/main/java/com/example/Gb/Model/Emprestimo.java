package com.example.Gb.Model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Emprestimo {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    private String data;

    @ManyToOne(cascade = CascadeType.ALL)
    private Aluno aluno;
    @ManyToOne(cascade = CascadeType.ALL)
    private Livro livro;
}
