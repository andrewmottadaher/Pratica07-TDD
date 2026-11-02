package com.gqs.pratica7.tdd;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ContaClienteTest {

    @Test
    void deveCriarContaComOsDadosInformados() {
        Cliente cliente = new Cliente(1, "Andrew", 10);
        ContaCliente conta = new ContaCliente(1, cliente, 500.0);
        assertEquals(1, conta.getId());
        assertEquals(cliente, conta.getCliente());
        assertEquals(500.0, conta.getSaldo(), 0.001);
    }

    @Test
    void deveCriarContaComIdECliente() {
        Cliente cliente = new Cliente(1, "Andrew", 10);
        ContaCliente conta = new ContaCliente(2, cliente);
        assertEquals(2, conta.getId());
        assertEquals(cliente, conta.getCliente());
        assertEquals(0.0, conta.getSaldo(), 0.001);
    }

    @Test
    void deveCriarContaInformandoApenasId() {
        ContaCliente conta = new ContaCliente(3);
        assertEquals(3, conta.getId());
        assertNull(conta.getCliente());
        assertEquals(0.0, conta.getSaldo(), 0.001);
    }

    @Test
    void deveAtualizarClienteDaConta() {
        Cliente clienteInicial = new Cliente(1, "Andrew", 10);
        Cliente novoCliente = new Cliente(2, "Maria", 15);
        ContaCliente conta = new ContaCliente(1, clienteInicial, 500.0);
        conta.setCliente(novoCliente);
        assertEquals(novoCliente, conta.getCliente());
    }
}