package com.example.Gb.Service;


import com.example.Gb.Model.Emprestimo;
import com.example.Gb.Model.Livro;
import com.example.Gb.Repository.EmprestimoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmprestimoService {


    private final EmprestimoRepository emprestimoRepository;

    public EmprestimoService(EmprestimoRepository emprestimoRepository) {
        this.emprestimoRepository = emprestimoRepository;
    }

    public List<Emprestimo> listarTodosEmprestimo() {
        return emprestimoRepository.findAll();
    }

    public Emprestimo cadastrarEmprestimo(Emprestimo emprestimo) {

        return emprestimoRepository.save(emprestimo);
    }

    public Emprestimo buscarEmprestimoPorId(Long emprestimoId) {
        return emprestimoRepository.findById(emprestimoId).orElse(null);
    }
    public Emprestimo realizarEmprestimo(Livro livro) {

        if (!livro.isEmprestado()) {

            Emprestimo emprestimo = new Emprestimo();
            emprestimo.setLivro(livro);

            emprestimoRepository.save(emprestimo);


            livro.setEmprestado(true);

            return emprestimo;
        } else {

            throw new RuntimeException("Livro já está emprestado");
        }
    }
}

