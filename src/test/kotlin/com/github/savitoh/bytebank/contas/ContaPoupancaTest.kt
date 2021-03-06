package com.github.savitoh.bytebank.contas

import com.github.savitoh.bytebank.clientes.Cliente
import com.github.savitoh.bytebank.auth.exception.FalhaAutenticacaoException
import com.github.savitoh.bytebank.contas.exceptions.SaldoInsuficienteException
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertFailsWith

internal class ContaPoupancaTest {

    private val senhaTitular = "123"
    private val titular = Cliente(nome = "Sávio", cpf = "111.111.111-11", senha = senhaTitular)
    private lateinit var contaPoupanca: ContaPoupanca

    @BeforeEach
    internal fun setUp() {
        contaPoupanca = ContaPoupanca(titular = titular, numero = 1)
    }

    @Test
    fun deve_permitir_depositar_quando_valor_positivo() {
        val valorDeposito = 10.00

        contaPoupanca.depositar(valorDeposito)

        assertEquals(valorDeposito, contaPoupanca.saldo)
    }

    @Test
    fun nao_deve_permitir_depositar_quando_valor_negativo() {
        val valorDeposito = -10.00

        contaPoupanca.depositar(valorDeposito)

        assertEquals(0.0, contaPoupanca.saldo)
    }

    @Test
    fun deve_permitir_sacar_quando_saldo_maior_saque() {
        val valorDeposito = 10.00
        val valorSaque = 9.00
        contaPoupanca.depositar(valorDeposito)

        contaPoupanca.sacar(valorSaque)

        assertEquals(1.0, contaPoupanca.saldo, ContaCorrenteTest.CONSTS.EPSILION_SAQUE)
    }

    @Test
    fun nao_deve_permitir_sacar_quando_saldo_igual_saque() {
        val valorDeposito = 10.00
        contaPoupanca.depositar(valorDeposito)

        contaPoupanca.sacar(valorDeposito)

        assertEquals(valorDeposito, contaPoupanca.saldo)
    }

    @Test
    fun nao_deve_permitir_sacar_quando_saldo_menor_saque() {
        val valorDeposito = 10.00
        val valorSaque = 12.00
        contaPoupanca.depositar(valorDeposito)

        contaPoupanca.sacar(valorSaque)

        assertEquals(10.00, contaPoupanca.saldo)
    }

    @Test
    fun deve_permitir_transferir_quando_saldo_maior_valor_transferencia() {
        val valorDeposito = 100.00
        val valorTransferencia = 10.00
        contaPoupanca.depositar(valorDeposito)
        val titularContaDestino = Cliente(nome = "Leticia", cpf = "222.222.222.22", senha = "senha")
        val contaDestino = ContaCorrente(titular = titularContaDestino, numero = 2)

        contaPoupanca.transfere(senhaTitular, valorTransferencia, contaDestino)

        assertEquals(valorTransferencia, contaDestino.saldo)
        assertEquals(90.00, contaPoupanca.saldo)
    }

    @Test
    fun nao_deve_permitir_transferir_quando_saldo_menor_valor_transferencia() {
        val valorDeposito = 100.00
        val valorTransferencia = 110.00
        contaPoupanca.depositar(valorDeposito)
        val titularContaDestino = Cliente(nome = "Leticia", cpf = "222.222.222.22", senha = "senha")
        val contaDestino = ContaCorrente(titular = titularContaDestino, numero = 2)

        val exception = assertFailsWith<SaldoInsuficienteException>(
            block = { contaPoupanca.transfere(senhaTitular, valorTransferencia, contaDestino) }
        )

        val mensagemEsperada =
            "O saldo é insuficiente. Saldo atual: ${contaPoupanca.saldo}. Valor a ser transferido: $valorTransferencia"
        assertEquals(mensagemEsperada, exception.message)
        assertEquals(0.0, contaDestino.saldo)
        assertEquals(valorDeposito, contaPoupanca.saldo)
    }

    @Test
    fun nao_deve_permitir_transferir_quando_nao_autentica() {
        val valorDeposito = 100.00
        val valorTransferencia = 10.00
        val senhaTitualarFalsa = "456"
        contaPoupanca.depositar(valorDeposito)
        val titularContaDestino = Cliente(nome = "Leticia", cpf = "222.222.222.22", senha = "senha")
        val contaDestino = ContaCorrente(titular = titularContaDestino, numero = 2)

        val exception = assertFailsWith<FalhaAutenticacaoException>(
            block = { contaPoupanca.transfere(senha = senhaTitualarFalsa, valor = valorTransferencia, destino = contaDestino) }
        )

        assertEquals("Falha na autenticação", exception.message)
        assertEquals(0.0, contaDestino.saldo)
        assertEquals(valorDeposito, contaPoupanca.saldo)
    }
}