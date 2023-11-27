package com.example.Desafio.Spring.Service;

import com.example.Desafio.Spring.Model.Produto;
import com.example.Desafio.Spring.Repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> getAllProdutos() {
        return produtoRepository.findAll();
    }

    public Produto getProdutoById(int id) {
        return produtoRepository.findById(id).orElse(null);
    }

    public Produto createProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Produto updateProduto(int id, Produto produtoAtualizado) {
        Produto produtoExistente = produtoRepository.findById(id).orElse(null);

        if (produtoExistente != null) {
            produtoExistente.setNome(produtoAtualizado.getNome());
            produtoExistente.setValor(produtoAtualizado.getValor());

            return produtoRepository.save(produtoExistente);
        } else {
            throw new RuntimeException("Produto não encontrado para atualização");
        }
    }
    public void deleteProduto(int id) {
        produtoRepository.deleteById(id);
    }

}
