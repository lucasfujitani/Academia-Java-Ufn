package com.example.Gb.Controller;

import com.example.Gb.Model.Emprestimo;
import com.example.Gb.Model.Livro;
import com.example.Gb.Service.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {

    private final EmprestimoService emprestimoService;

    @Autowired
    public EmprestimoController(EmprestimoService emprestimoService) {
        this.emprestimoService = emprestimoService;
    }

    @GetMapping
    public ResponseEntity<List<Emprestimo>> listarTodosEmprestimos() {
        List<Emprestimo> emprestimos = emprestimoService.listarTodosEmprestimo();
        return new ResponseEntity<>(emprestimos, HttpStatus.OK);
    }

    @GetMapping("/{emprestimoId}")
    public ResponseEntity<Emprestimo> buscarEmprestimoPorId(@PathVariable Long emprestimoId) {
        Emprestimo emprestimo = emprestimoService.buscarEmprestimoPorId(emprestimoId);
        if (emprestimo != null) {
            return new ResponseEntity<>(emprestimo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/realizar-emprestimo")
    public ResponseEntity<Object> realizarEmprestimo(@RequestBody Livro livro) {
        try {
            Emprestimo emprestimo = emprestimoService.realizarEmprestimo(livro);
            return new ResponseEntity<>(emprestimo, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
