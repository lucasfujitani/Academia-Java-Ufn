package com.example.Gb.Repository;

import com.example.Gb.Model.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {
}
