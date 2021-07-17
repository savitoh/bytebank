package com.github.savitoh.bytebank.contas

import com.github.savitoh.bytebank.clientes.Cliente
import com.github.savitoh.bytebank.contas.exceptions.SaldoInsuficienteException
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertFailsWith

internal class ContaPoupancaTest {

    private val titular = Cliente(nome = "Sávio", cpf = "111.111.111-11", senha = "123")
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

        contaPoupanca.transfere(valorTransferencia, contaDestino)

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

        assertFailsWith<SaldoInsuficienteException> (
            message = "O saldo é insuficiente.",
            block = {
                contaPoupanca.transfere(valorTransferencia, contaDestino)
            }
        )
        assertEquals(0.0, contaDestino.saldo)
        assertEquals(valorDeposito, contaPoupanca.saldo)
    }
}