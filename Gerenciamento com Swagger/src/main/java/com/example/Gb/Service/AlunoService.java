package com.example.Gb.Service;


import com.example.Gb.Model.Aluno;
import com.example.Gb.Repository.AlunoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

private AlunoRepository alunoRepository;

public AlunoService(AlunoRepository alunoRepository){
    this.alunoRepository = alunoRepository;

}

public List<Aluno> listarTodosAlunos(){
   return alunoRepository.findAll();
}

public Aluno cadastrarAluno (Aluno aluno){
    return alunoRepository.save(aluno);
}

public Aluno buscasAlunoPorId(Long alunoId){
    return alunoRepository.findById(alunoId).orElse(null);

}
    public List<Aluno> buscarAlunosPorName(String name) {
        return alunoRepository.findByNameContaining(name);
    }
}
