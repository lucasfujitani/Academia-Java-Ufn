package com.ufn.helloSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
public class HelloSpringApplication {

	// Lista de livros
	List<Livros> lista = new ArrayList<>();

	public static void main(String[] args) {
		SpringApplication.run(HelloSpringApplication.class, args);
	}

	public HelloSpringApplication() {
		// Inicializa a lista de livros no construtor
		lista.add(new Aventura("Romeu", "Vascao", 2.80));
		lista.add(new acao("Harry Potter", "J.K. Rowling", 15.99));
		lista.add(new Aventura("A Arte da Programação", "Code Guru", 29.90));
		lista.add(new acao("O Senhor dos Anéis", "J.R.R. Tolkien", 19.99));
		// Adicione mais livros conforme necessário
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "world") String name) {
		return String.format("Hello %s!", name);
	}

	@GetMapping("/livros")
	public List<Livros> hello() {
		return lista;
	}
}
