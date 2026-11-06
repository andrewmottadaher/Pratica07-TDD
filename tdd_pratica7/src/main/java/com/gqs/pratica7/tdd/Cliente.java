package com.gqs.pratica7.tdd;

public class Cliente {

    // Atributos da classe
    private int id;
    private String nome;
    private int desconto;
    private String genero;

    private void validarNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome invalido");
        }
    }

    // Construtor: recebe os dados iniciais do cliente
    public Cliente(int id, String nome, int desconto) {
        validarNome(nome);
        this.id = id;
        this.nome = nome;
        this.desconto = desconto;
        this.genero = "nd";
    }

    public void setNome(String nome) {
        validarNome(nome);
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getGenero() {
        return genero;
    }

    public int getDesconto() {
        return desconto;
    }

    public void setDesconto(int desconto) {
        this.desconto = desconto;
    }

    // O @Override indica que estou sobrescrevendo um método herdado de Object
    @Override
    public String toString() {
        return nome + "(" + id + ")(" + desconto + "%)";
    }

    public void setGenero(String genero) {
        if ("m".equals(genero) || "f".equals(genero) || "nd".equals(genero)) {
            this.genero = genero;
        } else {
            throw new IllegalArgumentException("Genero invalido");
        }
    }
}