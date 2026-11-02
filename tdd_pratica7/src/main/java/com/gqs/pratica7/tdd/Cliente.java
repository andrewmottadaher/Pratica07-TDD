
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

    // Retorna o identificador do cliente
    public int getId() {
        return id;
    }

    // Retorna o nome do cliente
    public String getNome() {
        return nome;
    }

    // Retorna o percentual de desconto
    public int getDesconto() {
        return desconto;
    }

    // Retorna o genero do cliente
    public String getGenero() {
        return genero;
    }
}