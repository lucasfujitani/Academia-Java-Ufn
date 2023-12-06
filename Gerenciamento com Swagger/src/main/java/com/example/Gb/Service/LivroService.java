package com.example.Gb.Service;


import com.example.Gb.Model.Emprestimo;
import com.example.Gb.Model.Livro;
import com.example.Gb.Repository.EmprestimoRepository;
import com.example.Gb.Repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    private final LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public List<Livro> listarTodosLivros() {
        return livroRepository.findAll();
    }

    public Livro cadastrarLivro(Livro livro) {

        return livroRepository.save(livro);
    }
    public Livro buscarLivroPorId(Long livroId) {
        return livroRepository.findById(livroId).orElse(null);
    }

    public List<Livro> buscarLivrosPorNome(String nome) {
        return livroRepository.findByTituloContaining(nome);
    }


}
