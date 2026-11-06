package com.gqs.pratica7.tdd;

public class ContaCliente {

    private int id;
    private Cliente cliente;
    private double saldo;

    private void validarSaldo(double saldo) {
        if (Double.isNaN(saldo) || Double.isInfinite(saldo) || saldo < 0) {
            throw new IllegalArgumentException("Saldo invalido");
        }
    }

    public ContaCliente(int id, Cliente cliente, double saldo) {
        validarSaldo(saldo);
        this.id = id;
        this.cliente = cliente;
        this.saldo = saldo;
    }

    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public ContaCliente(int id, Cliente cliente) {
        this.id = id;
        this.cliente = cliente;
        this.saldo = 0.0;
    }

    public ContaCliente(int id) {
        this.id = id;
        this.saldo = 0.0;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setSaldo(double saldo) {
        validarSaldo(saldo);
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return cliente + " saldo=R$" +
                String.format(java.util.Locale.US, "%.2f", saldo);
    }

    public double addDeposito(double valor) {
        if (Double.isNaN(valor) || Double.isInfinite(valor) || valor <= 0) {
            throw new IllegalArgumentException("Valor do deposito invalido");
        }
        double novoSaldo = saldo + valor;
        if (Double.isInfinite(novoSaldo)) {
            throw new IllegalArgumentException("Saldo resultante invalido");
        }
        saldo = novoSaldo;
        return saldo;
    }

    public double subSaldo(double valor) {
        if (Double.isNaN(valor) || Double.isInfinite(valor)) {
            throw new IllegalArgumentException("Valor do saque invalido");
        }
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
        } else {
            System.out.println("Saque nao permitido ou saldo insuficiente.");
        }
        return saldo;
    }
}