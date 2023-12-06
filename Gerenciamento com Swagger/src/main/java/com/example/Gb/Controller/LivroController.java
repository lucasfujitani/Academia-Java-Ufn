package com.example.Gb.Controller;


import com.example.Gb.Model.Aluno;
import com.example.Gb.Model.Livro;
import com.example.Gb.Service.AlunoService;
import com.example.Gb.Service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroService livroService;

    @Autowired
    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @GetMapping
    public ResponseEntity<List<Livro>> listarTodosLivros() {
        List<Livro> livros = livroService.listarTodosLivros();
        return new ResponseEntity<>(livros, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Livro> cadastrarLivro(@RequestBody Livro livro) {
        Livro novoLivro = livroService.cadastrarLivro(livro);
        return new ResponseEntity<>(novoLivro, HttpStatus.CREATED);
    }

    @GetMapping("/{livroId}")
    public ResponseEntity<Livro> buscarLivroPorId(@PathVariable Long livroId) {
        Livro livro = livroService.buscarLivroPorId(livroId);
        if (livro != null) {
            return new ResponseEntity<>(livro, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/por-nome/{nome}")
    public ResponseEntity<List<Livro>> buscarLivrosPorNome(@PathVariable String nome) {
        List<Livro> livros = livroService.buscarLivrosPorNome(nome);
        if (!livros.isEmpty()) {
            return new ResponseEntity<>(livros, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
