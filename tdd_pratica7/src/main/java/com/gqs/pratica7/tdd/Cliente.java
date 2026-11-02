
package com.gqs.pratica7.tdd;

public class Cliente {

    // Atributos da classe
    private int id;
    private String nome;
    private int desconto;
    private String genero;

    // Construtor: recebe os dados iniciais do cliente
    public Cliente(int id, String nome, int desconto) {
        this.id = id;
        this.nome = nome;
        this.desconto = desconto;
        this.genero = "nd";
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getDesconto() {
        return desconto;
    }

    public String getGenero() {
        return genero;
    }

    public void setDesconto(int desconto) {
        this.desconto = desconto;
    }
}