package com.gqs.pratica7.tdd;

public class FaturaCliente {

    private int id;
    private Cliente cliente;
    private double valor;

    public FaturaCliente(int id, Cliente cliente, double valor) {
        this.id = id;
        this.cliente = cliente;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getValor() {
        return valor;
    }

    public FaturaCliente(int id) {
        this.id = id;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getValorComDesconto() {
        return valor * (1 - cliente.getDesconto() / 100.0);
    }
}