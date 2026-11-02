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
}