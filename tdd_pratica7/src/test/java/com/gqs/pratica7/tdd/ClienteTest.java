package com.gqs.pratica7.tdd;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    @Test
    void deveCriarClienteComOsDadosInformados() {
        Cliente cliente = new Cliente(1, "Andrew", 10);
        assertEquals(1, cliente.getId());
        assertEquals("Andrew", cliente.getNome());
        assertEquals(10, cliente.getDesconto());
    }

    @Test
    void deveInicializarGeneroComoNaoDefinido() {
        Cliente cliente = new Cliente(1, "Andrew", 10);
        assertEquals("nd", cliente.getGenero());
    }

    @Test
    void deveAtualizarDescontoDoCliente() {
        Cliente cliente = new Cliente(1, "Andrew", 10);
        cliente.setDesconto(20);
        assertEquals(20, cliente.getDesconto());
    }

    @Test
    void deveRetornarRepresentacaoTextualDoCliente() {
        Cliente cliente = new Cliente(1, "Andrew", 10);
        assertEquals("Andrew(1)(10%)", cliente.toString());
    }

    @Test
    void deveAtualizarGeneroParaMasculino() {
        Cliente cliente = new Cliente(1, "Andrew", 10);
        cliente.setGenero("m");
        assertEquals("m", cliente.getGenero());
    }

    @Test
    void deveAtualizarGeneroParaFeminino() {
        Cliente cliente = new Cliente(1, "Andrew", 10);
        cliente.setGenero("f");
        assertEquals("f", cliente.getGenero());
    }

    @Test
    void deveAtualizarGeneroParaNaoDefinido() {
        Cliente cliente = new Cliente(1, "Andrew", 10);
        cliente.setGenero("nd");
        assertEquals("nd", cliente.getGenero());
    }

    @Test
    void naoDeveAceitarGeneroInvalido() {
        Cliente cliente = new Cliente(1, "Andrew", 10);
        assertThrows(
                IllegalArgumentException.class,
                () -> cliente.setGenero("x"));
        assertEquals("nd", cliente.getGenero());
    }

    @Test
    void naoDeveCriarClienteComNomeVazio() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Cliente(1, "", 10));
    }

    @Test
    void naoDeveCriarClienteComNomeCompostoPorEspacos() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Cliente(1, "   ", 10));
    }

    @Test
    void naoDeveCriarClienteComNomeNulo() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Cliente(1, null, 10));
    }

    @Test
    void deveAtualizarNomeDoCliente() {
        Cliente cliente = new Cliente(1, "Andrew", 10);
        cliente.setNome("Carlos");
        assertEquals("Carlos", cliente.getNome());
    }

    @Test
    void naoDeveAtualizarNomeParaVazio() {
        Cliente cliente = new Cliente(1, "Andrew", 10);
        assertThrows(
                IllegalArgumentException.class,
                () -> cliente.setNome(""));
        assertEquals("Andrew", cliente.getNome());
    }

    @Test
    void naoDeveAtualizarNomeParaEspacos() {
        Cliente cliente = new Cliente(1, "Andrew", 10);
        assertThrows(
                IllegalArgumentException.class,
                () -> cliente.setNome("   "));
        assertEquals("Andrew", cliente.getNome());
    }

    @Test
    void naoDeveAtualizarNomeParaNulo() {
        Cliente cliente = new Cliente(1, "Andrew", 10);
        assertThrows(
                IllegalArgumentException.class,
                () -> cliente.setNome(null));
        assertEquals("Andrew", cliente.getNome());
    }

    @Test
    void naoDeveCriarClienteComDescontoNegativo() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Cliente(1, "Andrew", -10));
    }

    @Test
    void naoDeveCriarClienteComDescontoSuperiorACem() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Cliente(1, "Andrew", 110));
    }

    @Test
    void deveCriarClienteComDescontoZero() {
        Cliente cliente = new Cliente(1, "Andrew", 0);
        assertEquals(0, cliente.getDesconto());
    }

    @Test
    void deveCriarClienteComDescontoDeCemPorCento() {
        Cliente cliente = new Cliente(1, "Andrew", 100);
        assertEquals(100, cliente.getDesconto());
    }

    @Test
    void naoDeveAtualizarDescontoParaValorNegativo() {
        Cliente cliente = new Cliente(1, "Andrew", 10);
        assertThrows(
                IllegalArgumentException.class,
                () -> cliente.setDesconto(-10));
        assertEquals(10, cliente.getDesconto());
    }

    @Test
    void naoDeveAtualizarDescontoParaValorSuperiorACem() {
        Cliente cliente = new Cliente(1, "Andrew", 10);
        assertThrows(
                IllegalArgumentException.class,
                () -> cliente.setDesconto(110));
        assertEquals(10, cliente.getDesconto());
    }

    @Test
    void deveAtualizarDescontoParaValorValido() {
        Cliente cliente = new Cliente(1, "Andrew", 10);
        cliente.setDesconto(50);
        assertEquals(50, cliente.getDesconto());
    }
}