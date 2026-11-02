
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
}