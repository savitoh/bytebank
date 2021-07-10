package com.github.savitoh.bytebank.contas

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class ContaPoupancaTest {

    private lateinit var contaPoupanca: ContaPoupanca

    @BeforeEach
    internal fun setUp() {
        contaPoupanca = ContaPoupanca(titular = "Sávio", numero = 1)
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
        val contaDestino = ContaCorrente(titular = "Leticia", numero = 2)

        val transferido = contaPoupanca.transfere(valorTransferencia, contaDestino)

        assertTrue { transferido }
        assertEquals(valorTransferencia, contaDestino.saldo)
        assertEquals(90.00, contaPoupanca.saldo)
    }

    @Test
    fun nao_deve_permitir_transferir_quando_saldo_menor_valor_transferencia() {
        val valorDeposito = 100.00
        val valorTransferencia = 110.00
        contaPoupanca.depositar(valorDeposito)
        val contaDestino = ContaCorrente(titular = "Leticia", numero = 2)

        val transferido = contaPoupanca.transfere(valorTransferencia, contaDestino)

        assertFalse { transferido }
        assertEquals(0.0, contaDestino.saldo)
        assertEquals(valorDeposito, contaPoupanca.saldo)
    }
}