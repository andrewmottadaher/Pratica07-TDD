package com.gqs.pratica7.tdd;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FaturaClienteTest {

    @Test
    void deveCriarFaturaComOsDadosInformados() {
        Cliente cliente = new Cliente(1, "Andrew", 10);
        FaturaCliente fatura = new FaturaCliente(1, cliente, 100.0);
        assertEquals(1, fatura.getId());
        assertEquals(cliente, fatura.getCliente());
        assertEquals(100.0, fatura.getValor(), 0.001);
    }

    @Test
    void deveCriarFaturaInformandoApenasId() {
        FaturaCliente fatura = new FaturaCliente(2);
        assertEquals(2, fatura.getId());
        assertNull(fatura.getCliente());
        assertEquals(0.0, fatura.getValor(), 0.001);
    }

    @Test
    void deveAtualizarClienteDaFatura() {
        Cliente clienteInicial = new Cliente(1, "Andrew", 10);
        Cliente novoCliente = new Cliente(2, "Maria", 15);
        FaturaCliente fatura = new FaturaCliente(1, clienteInicial, 100.0);
        fatura.setCliente(novoCliente);
        assertEquals(novoCliente, fatura.getCliente());
    }

    @Test
    void deveAtualizarValorDaFatura() {
        Cliente cliente = new Cliente(1, "Andrew", 10);
        FaturaCliente fatura = new FaturaCliente(1, cliente, 100.0);
        fatura.setValor(250.0);
        assertEquals(250.0, fatura.getValor(), 0.001);
    }

    @Test
    void deveCalcularValorDaFaturaComDesconto() {
        Cliente cliente = new Cliente(1, "Andrew", 10);
        FaturaCliente fatura = new FaturaCliente(1, cliente, 100.0);
        assertEquals(90.0, fatura.getValorComDesconto(), 0.001);
    }
}