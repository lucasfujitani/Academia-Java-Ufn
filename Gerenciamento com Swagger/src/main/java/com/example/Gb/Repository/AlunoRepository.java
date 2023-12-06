package com.example.Gb.Repository;

import com.example.Gb.Model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AlunoRepository  extends JpaRepository<Aluno, Long> {

    List<Aluno> findByNameContaining(String name);
}
