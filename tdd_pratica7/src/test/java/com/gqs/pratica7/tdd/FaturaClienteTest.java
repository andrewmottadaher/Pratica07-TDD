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

    @Test
    void deveRetornarRepresentacaoTextualDaFatura() {
        Cliente cliente = new Cliente(1, "Andrew", 10);
        FaturaCliente fatura = new FaturaCliente(1, cliente, 100.0);
        assertEquals(
                "Fatura [id=1, cliente=Andrew(1)(10%), valor=100.0 ]",
                fatura.toString());
    }

    @Test
    void naoDeveCriarFaturaComValorNegativo() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new FaturaCliente(
                        1,
                        new Cliente(1, "Andrew", 10),
                        -100.0));
    }

    @Test
    void deveCriarFaturaComValorZero() {
        Cliente cliente = new Cliente(1, "Andrew", 10);
        FaturaCliente fatura = new FaturaCliente(1, cliente, 0.0);
        assertEquals(0.0, fatura.getValor(), 0.001);
    }

    @Test
    void naoDeveAtualizarValorDaFaturaParaValorNegativo() {
        Cliente cliente = new Cliente(1, "Andrew", 10);
        FaturaCliente fatura = new FaturaCliente(1, cliente, 100.0);
        assertThrows(
                IllegalArgumentException.class,
                () -> fatura.setValor(-50.0));
        assertEquals(100.0, fatura.getValor(), 0.001);
    }

    @Test
    void naoDeveCalcularDescontoSemClienteAssociado() {
        FaturaCliente fatura = new FaturaCliente(1);
        assertThrows(
                IllegalStateException.class,
                () -> fatura.getValorComDesconto());
    }

    @Test
    void deveAtualizarValorDaFaturaParaZero() {
        Cliente cliente = new Cliente(1, "Andrew", 10);
        FaturaCliente fatura = new FaturaCliente(1, cliente, 100.0);
        fatura.setValor(0.0);
        assertEquals(0.0, fatura.getValor(), 0.001);
    }

    @Test
    void naoDeveCriarFaturaComValorNaN() {
        Cliente cliente = new Cliente(1, "Andrew", 10);
        assertThrows(
                IllegalArgumentException.class,
                () -> new FaturaCliente(1, cliente, Double.NaN));
    }

    @Test
    void naoDeveCriarFaturaComValorInfinitoPositivo() {
        Cliente cliente = new Cliente(1, "Andrew", 10);
        assertThrows(
                IllegalArgumentException.class,
                () -> new FaturaCliente(1, cliente, Double.POSITIVE_INFINITY));
    }

    @Test
    void naoDeveCriarFaturaComValorInfinitoNegativo() {
        Cliente cliente = new Cliente(1, "Andrew", 10);
        assertThrows(
                IllegalArgumentException.class,
                () -> new FaturaCliente(1, cliente, Double.NEGATIVE_INFINITY));
    }
}