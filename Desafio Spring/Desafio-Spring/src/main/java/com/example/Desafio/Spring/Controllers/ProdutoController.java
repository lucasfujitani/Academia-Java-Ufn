package com.example.Desafio.Spring.Controllers;

import com.example.Desafio.Spring.Service.ProdutoService;
import com.example.Desafio.Spring.Model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

    @RestController
    @RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    @Autowired
    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public ResponseEntity<List<Produto>> getAllProdutos() {
        List<Produto> produtos = produtoService.getAllProdutos();
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> getProdutoById(@PathVariable int id) {
        Produto produto = produtoService.getProdutoById(id);
        return ResponseEntity.ok(produto);
    }

    @PostMapping
    public ResponseEntity<Produto> createProduto(@RequestBody Produto produto) {
        Produto novoProduto = produtoService.createProduto(produto);
        return ResponseEntity.ok(novoProduto);
    }

        @PutMapping("/{id}")
        public ResponseEntity<Produto> updateProduto(@PathVariable int id, @RequestBody Produto produto) {
            Produto produtoAtualizado = produtoService.updateProduto(id, produto);
            if (produtoAtualizado != null) {
                return ResponseEntity.ok(produtoAtualizado);
            } else {
                return ResponseEntity.notFound().build();
            }
        }


        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteProduto(@PathVariable int id) {
            produtoService.deleteProduto(id);
            return ResponseEntity.noContent().build();
        }
    }

