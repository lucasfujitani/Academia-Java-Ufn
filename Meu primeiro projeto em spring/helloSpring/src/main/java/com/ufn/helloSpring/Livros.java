package com.ufn.helloSpring;

public abstract class Livros {
    String nome;
    String autor;
    double preço;
    String genero;

    public Livros(String nome, String autor, double preço, String genero) {
        this.nome = nome;
        this.autor = autor;
        this.preço = preço;
        this.genero = genero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public double getPreço() {
        return preço;
    }

    public void setPreço(double preço) {
        this.preço = preço;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
// Métodos getters e setters (não mostrados para brevidade)
}
