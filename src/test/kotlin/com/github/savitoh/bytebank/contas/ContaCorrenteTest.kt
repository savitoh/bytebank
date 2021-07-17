package com.github.savitoh.bytebank.contas

import com.github.savitoh.bytebank.clientes.Cliente
import com.github.savitoh.bytebank.contas.ContaCorrenteTest.CONSTS.EPSILION_SAQUE
import com.github.savitoh.bytebank.contas.exceptions.SaldoInsuficienteException
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

internal class ContaCorrenteTest {

    object CONSTS {
        const val EPSILION_SAQUE = 0.0001
    }

    private val titular = Cliente(nome = "Sávio", cpf = "111.111.111-11", senha = "123")
    private lateinit var contaCorrente: ContaCorrente

    @BeforeEach
    internal fun setUp() {
        contaCorrente = ContaCorrente(titular = titular, numero = 1)
    }

    @Test
    fun deve_permitir_depositar_quando_valor_positivo() {
        val valorDeposito = 10.00

        contaCorrente.depositar(valorDeposito)

        assertEquals(valorDeposito, contaCorrente.saldo)
    }

    @Test
    fun nao_deve_permitir_depositar_quando_valor_negativo() {
        val valorDeposito = -10.00

        contaCorrente.depositar(valorDeposito)

        assertEquals(0.0, contaCorrente.saldo)
    }

    @Test
    fun deve_permitir_sacar_quando_saldo_maior_saque() {
        val valorDeposito = 10.00
        val valorSaque = 9.00
        contaCorrente.depositar(valorDeposito)

        contaCorrente.sacar(valorSaque)

        assertEquals(0.90, contaCorrente.saldo, EPSILION_SAQUE)
    }

    @Test
    fun nao_deve_permitir_sacar_quando_saldo_igual_saque() {
        val valorDeposito = 10.00
        contaCorrente.depositar(valorDeposito)

        contaCorrente.sacar(valorDeposito)

        assertEquals(valorDeposito, contaCorrente.saldo)
    }

    @Test
    fun nao_deve_permitir_sacar_quando_saldo_menor_saque() {
        val valorDeposito = 10.00
        val valorSaque = 12.00
        contaCorrente.depositar(valorDeposito)

        contaCorrente.sacar(valorSaque)

        assertEquals(10.00, contaCorrente.saldo)
    }

    @Test
    fun deve_permitir_transferir_quando_saldo_maior_valor_transferencia() {
        val valorDeposito = 100.00
        val valorTransferencia = 10.00
        contaCorrente.depositar(valorDeposito)
        val titularContaDestino = Cliente(nome = "Leticia", cpf = "222.222.222.22", senha = "senha")
        val contaDestino = ContaPoupanca(titular = titularContaDestino, numero = 2)

        contaCorrente.transfere(valorTransferencia, contaDestino)

        assertEquals(valorTransferencia, contaDestino.saldo)
        assertEquals(90.00, contaCorrente.saldo)
    }

    @Test
    fun nao_deve_permitir_transferir_quando_saldo_menor_valor_transferencia() {
        val valorDeposito = 100.00
        val valorTransferencia = 110.00
        contaCorrente.depositar(valorDeposito)
        val titularContaDestino = Cliente(nome = "Leticia", cpf = "222.222.222.22", senha = "senha")
        val contaDestino = ContaPoupanca(titular = titularContaDestino, numero = 2)


        val exception = assertFailsWith<SaldoInsuficienteException> (
            block = { contaCorrente.transfere(valorTransferencia, contaDestino) }
        )

        val mensagemEsperada = "O saldo é insuficiente. Saldo atual: ${contaCorrente.saldo}. Valor a ser transferido: $valorTransferencia"
        assertEquals(mensagemEsperada, exception.message)
        assertEquals(0.0, contaDestino.saldo)
        assertEquals(valorDeposito, contaCorrente.saldo)
    }
}