package com.gqs.pratica7.tdd;

public class FaturaCliente {

    private int id;
    private Cliente cliente;
    private double valor;

    private void validarValor(double valor) {
        if (valor < 0) {
            throw new IllegalArgumentException("Valor da fatura invalido");
        }
    }

    public FaturaCliente(int id, Cliente cliente, double valor) {
        validarValor(valor);
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
        validarValor(valor);
        this.valor = valor;
    }

    public double getValorComDesconto() {
        if (cliente == null) {
            throw new IllegalStateException(
                    "Fatura sem cliente associado");
        }
        return valor * (1 - cliente.getDesconto() / 100.0);
    }

    @Override
    public String toString() {
        return "Fatura [id=" + id + ", cliente=" + cliente + ", valor=" + valor + " ]";
    }
}