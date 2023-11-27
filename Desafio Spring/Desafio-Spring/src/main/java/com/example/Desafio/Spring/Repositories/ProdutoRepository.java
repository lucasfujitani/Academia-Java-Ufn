package com.example.Desafio.Spring.Repositories;

import com.example.Desafio.Spring.Model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

    // Consulta para encontrar produtos por nome
    List<Produto> findByNome(String nome);

    // Consulta para encontrar produtos por valor maior que o especificado
    List<Produto> findByValorGreaterThan(double valor);

    // Consulta para encontrar produtos por valor menor que o especificado
    List<Produto> findByValorLessThan(double valor);

    // Consulta para encontrar produtos por nome e valor
    List<Produto> findByNomeAndValor(String nome, double valor);

    // Adicione consultas adicionais conforme necessário
}