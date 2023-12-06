package com.example.Gb.Controller;

import com.example.Gb.Model.Aluno;
import com.example.Gb.Service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoService alunoService;

    @Autowired
    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @GetMapping
    public ResponseEntity<List<Aluno>> listarTodosAlunos() {
        List<Aluno> alunos = alunoService.listarTodosAlunos();
        return new ResponseEntity<>(alunos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Aluno> cadastrarAluno(@RequestBody Aluno aluno) {
        Aluno novoAluno = alunoService.cadastrarAluno(aluno);
        return new ResponseEntity<>(novoAluno, HttpStatus.CREATED);
    }

    @GetMapping("/{alunoId}")
    public ResponseEntity<Aluno> buscarAlunoPorId(@PathVariable Long alunoId) {
        Aluno aluno = alunoService.buscasAlunoPorId(alunoId);
        if (aluno != null) {
            return new ResponseEntity<>(aluno, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/por-name/{name}")
    public ResponseEntity<List<Aluno>> buscarAlunosPorName(@PathVariable String name) {
        List<Aluno> alunos = alunoService.buscarAlunosPorName(name);
        if (!alunos.isEmpty()) {
            return new ResponseEntity<>(alunos, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
