package com.github.savitoh.bytebank.contas

import com.github.savitoh.bytebank.clientes.Cliente
import kotlin.test.Test
import kotlin.test.assertEquals

internal class ContaTest {

    @Test
    fun deve_retornar_quantidade_contas_criadas() {
        val titularContaSalario = Cliente(nome = "Sávio", cpf = "111.111.111-11", senha = "123")
        val contaSalario = ContaSalario(titular = titularContaSalario, numero = 1)
        val titularContaPoupanca = Cliente(nome = "Fernanda", cpf = "111.111.111-11", senha = "234")
        val contaPoupanca = ContaPoupanca(titular = titularContaPoupanca, numero = 1)
        val titularContaCorrente = Cliente(nome = "Leticia", cpf = "111.111.111-11", senha = "345")
        val contaCorrente = ContaCorrente(titular = titularContaCorrente, numero = 1)

        assertEquals(3, contaSalario.getTotal())
        assertEquals(3, contaPoupanca.getTotal())
        assertEquals(3, contaCorrente.getTotal())
    }
}