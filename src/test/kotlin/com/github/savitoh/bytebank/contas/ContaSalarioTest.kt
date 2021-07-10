package com.github.savitoh.bytebank.contas

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class ContaSalarioTest {

    private lateinit var contaSalario: ContaSalario

    @BeforeEach
    internal fun setUp() {
        contaSalario = ContaSalario(titular = "Sávio", numero = 1)
    }

    @Test
    fun deve_permitir_depositar_quando_valor_positivo() {
        val valorDeposito = 10.00

        contaSalario.depositar(valorDeposito)

        assertEquals(valorDeposito, contaSalario.saldo)
    }

    @Test
    fun nao_deve_permitir_depositar_quando_valor_negativo() {
        val valorDeposito = -10.00

        contaSalario.depositar(valorDeposito)

        assertEquals(0.0, contaSalario.saldo)
    }

    @Test
    fun deve_permitir_sacar_quando_saldo_maior_saque() {
        val valorDeposito = 10.00
        val valorSaque = 9.00
        contaSalario.depositar(valorDeposito)

        contaSalario.sacar(valorSaque)

        assertEquals(1.00, contaSalario.saldo)
    }

    @Test
    fun deve_permitir_sacar_quando_saldo_igual_saque() {
        val valorDeposito = 10.00
        contaSalario.depositar(valorDeposito)

        contaSalario.sacar(valorDeposito)

        assertEquals(0.0, contaSalario.saldo)
    }

    @Test
    fun nao_deve_permitir_sacar_quando_saldo_menor_saque() {
        val valorDeposito = 10.00
        val valorSaque = 12.00
        contaSalario.depositar(valorDeposito)

        contaSalario.sacar(valorSaque)

        assertEquals(10.00, contaSalario.saldo)
    }
}