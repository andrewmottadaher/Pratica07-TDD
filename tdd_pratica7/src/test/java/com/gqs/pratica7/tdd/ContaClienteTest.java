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

    @Test
    void deveAtualizarSaldoDaConta() {
        Cliente cliente = new Cliente(1, "Andrew", 10);
        ContaCliente conta = new ContaCliente(1, cliente, 500.0);
        conta.setSaldo(750.0);
        assertEquals(750.0, conta.getSaldo(), 0.001);
    }

    @Test
    void deveRetornarRepresentacaoTextualDaConta() {
        Cliente cliente = new Cliente(1, "Andrew", 10);
        ContaCliente conta = new ContaCliente(5, cliente, 500.5);
        assertEquals(
                "Andrew(1)(10%) saldo=R$500.50",
                conta.toString());
    }

    @Test
    void deveAdicionarDepositoAoSaldoDaConta() {
        Cliente cliente = new Cliente(1, "Andrew", 10);
        ContaCliente conta = new ContaCliente(1, cliente, 500.0);
        double novoSaldo = conta.addDeposito(200.0);
        assertEquals(700.0, novoSaldo, 0.001);
        assertEquals(700.0, conta.getSaldo(), 0.001);
    }

    @Test
    void deveSubtrairValorDoSaldoDaConta() {
        Cliente cliente = new Cliente(1, "Andrew", 10);
        ContaCliente conta = new ContaCliente(1, cliente, 500.0);
        double novoSaldo = conta.subSaldo(200.0);
        assertEquals(300.0, novoSaldo, 0.001);
        assertEquals(300.0, conta.getSaldo(), 0.001);
    }

    @Test
    void naoDevePermitirSaqueSuperiorAoSaldo() {
        Cliente cliente = new Cliente(1, "Andrew", 10);
        ContaCliente conta = new ContaCliente(1, cliente, 500.0);
        double saldoAtual = conta.subSaldo(600.0);
        assertEquals(500.0, saldoAtual, 0.001);
        assertEquals(500.0, conta.getSaldo(), 0.001);
    }

    @Test
    void naoDevePermitirSaqueComValorNegativo() {
        Cliente cliente = new Cliente(1, "Andrew", 10);
        ContaCliente conta = new ContaCliente(1, cliente, 500.0);
        double saldoAtual = conta.subSaldo(-100.0);
        assertEquals(500.0, saldoAtual, 0.001);
        assertEquals(500.0, conta.getSaldo(), 0.001);
    }

    @Test
    void naoDeveCriarContaComSaldoNegativo() {
        Cliente cliente = new Cliente(1, "Andrew", 10);
        assertThrows(IllegalArgumentException.class, () -> new ContaCliente(1, cliente, -100.0));
    }

    @Test
    void deveCriarContaComSaldoZero() {
        Cliente cliente = new Cliente(1, "Andrew", 10);
        ContaCliente conta = new ContaCliente(1, cliente, 0.0);
        assertEquals(0.0, conta.getSaldo(), 0.001);
    }

    @Test
    void naoDeveAtualizarSaldoParaValorNegativo() {
        Cliente cliente = new Cliente(1, "Andrew", 10);
        ContaCliente conta = new ContaCliente(1, cliente, 100.0);
        assertThrows(
                IllegalArgumentException.class,
                () -> conta.setSaldo(-50.0));
        assertEquals(100.0, conta.getSaldo(), 0.001);
    }

    @Test
    void naoDeveAceitarDepositoComValorNegativo() {
        Cliente cliente = new Cliente(1, "Andrew", 10);
        ContaCliente conta = new ContaCliente(1, cliente, 100.0);
        assertThrows(
                IllegalArgumentException.class,
                () -> conta.addDeposito(-50.0));
        assertEquals(100.0, conta.getSaldo(), 0.001);
    }

    @Test
    void naoDeveAceitarDepositoComValorZero() {
        Cliente cliente = new Cliente(1, "Andrew", 10);
        ContaCliente conta = new ContaCliente(1, cliente, 100.0);
        assertThrows(
                IllegalArgumentException.class,
                () -> conta.addDeposito(0.0));
        assertEquals(100.0, conta.getSaldo(), 0.001);
    }

    @Test
    void naoDeveAceitarDepositoComValorNaN() {
        Cliente cliente = new Cliente(1, "Andrew", 10);
        ContaCliente conta = new ContaCliente(1, cliente, 100.0);
        assertThrows(
                IllegalArgumentException.class,
                () -> conta.addDeposito(Double.NaN));
        assertEquals(100.0, conta.getSaldo(), 0.001);
    }

    @Test
    void naoDeveAceitarDepositoComInfinitoPositivo() {
        Cliente cliente = new Cliente(1, "Andrew", 10);
        ContaCliente conta = new ContaCliente(1, cliente, 100.0);
        assertThrows(
                IllegalArgumentException.class,
                () -> conta.addDeposito(Double.POSITIVE_INFINITY));
        assertEquals(100.0, conta.getSaldo(), 0.001);
    }

    @Test
    void naoDeveAceitarDepositoComInfinitoNegativo() {
        Cliente cliente = new Cliente(1, "Andrew", 10);
        ContaCliente conta = new ContaCliente(1, cliente, 100.0);
        assertThrows(
                IllegalArgumentException.class,
                () -> conta.addDeposito(Double.NEGATIVE_INFINITY));
        assertEquals(100.0, conta.getSaldo(), 0.001);
    }

    @Test
    void naoDeveAceitarSaqueComValorNaN() {
        Cliente cliente = new Cliente(1, "Andrew", 10);
        ContaCliente conta = new ContaCliente(1, cliente, 100.0);
        assertThrows(
                IllegalArgumentException.class,
                () -> conta.subSaldo(Double.NaN));
        assertEquals(100.0, conta.getSaldo(), 0.001);
    }

    @Test
    void naoDeveAceitarSaqueComInfinitoPositivo() {
        Cliente cliente = new Cliente(1, "Andrew", 10);
        ContaCliente conta = new ContaCliente(1, cliente, 100.0);
        assertThrows(
                IllegalArgumentException.class,
                () -> conta.subSaldo(Double.POSITIVE_INFINITY));
        assertEquals(100.0, conta.getSaldo(), 0.001);
    }

    @Test
    void naoDeveAceitarSaqueComInfinitoNegativo() {
        Cliente cliente = new Cliente(1, "Andrew", 10);
        ContaCliente conta = new ContaCliente(1, cliente, 100.0);
        assertThrows(
                IllegalArgumentException.class,
                () -> conta.subSaldo(Double.NEGATIVE_INFINITY));
        assertEquals(100.0, conta.getSaldo(), 0.001);
    }

    @Test
    void devePermitirSaqueDoSaldoTotal() {
        Cliente cliente = new Cliente(1, "Andrew", 10);
        ContaCliente conta = new ContaCliente(1, cliente, 100.0);
        double novoSaldo = conta.subSaldo(100.0);
        assertEquals(0.0, novoSaldo, 0.001);
        assertEquals(0.0, conta.getSaldo(), 0.001);
    }

    @Test
    void naoDevePermitirSaqueComValorZero() {
        Cliente cliente = new Cliente(1, "Andrew", 10);
        ContaCliente conta = new ContaCliente(1, cliente, 100.0);
        double novoSaldo = conta.subSaldo(0.0);
        assertEquals(100.0, novoSaldo, 0.001);
        assertEquals(100.0, conta.getSaldo(), 0.001);
    }

    @Test
    void naoDevePermitirSaqueComValorNegativo() {
        Cliente cliente = new Cliente(1, "Andrew", 10);
        ContaCliente conta = new ContaCliente(1, cliente, 100.0);
        double novoSaldo = conta.subSaldo(-50.0);
        assertEquals(100.0, novoSaldo, 0.001);
        assertEquals(100.0, conta.getSaldo(), 0.001);
    }

    @Test
    void naoDevePermitirSaqueSuperiorAoSaldoDisponivel() {
        Cliente cliente = new Cliente(1, "Andrew", 10);
        ContaCliente conta = new ContaCliente(1, cliente, 100.0);
        double novoSaldo = conta.subSaldo(150.0);
        assertEquals(100.0, novoSaldo, 0.001);
        assertEquals(100.0, conta.getSaldo(), 0.001);
    }

    @Test
    void deveCriarContaComClienteESaldoZero() {
        Cliente cliente = new Cliente(1, "Andrew", 10);
        ContaCliente conta = new ContaCliente(1, cliente);
        assertEquals(0.0, conta.getSaldo(), 0.001);
        assertEquals(cliente, conta.getCliente());
    }

    @Test
    void deveCriarContaApenasComIdESaldoZero() {
        ContaCliente conta = new ContaCliente(1);
        assertNull(conta.getCliente());
    }

    @Test
    void naoDeveCriarContaComSaldoNaN() {
        Cliente cliente = new Cliente(1, "Andrew", 10);
        assertThrows(
                IllegalArgumentException.class,
                () -> new ContaCliente(1, cliente, Double.NaN));
    }
}