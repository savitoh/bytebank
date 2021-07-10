package com.github.savitoh.bytebank.funcionarios

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class DiretorTest {

    private val diretor = Diretor(
        nome = "Marecelo",
        cpf = "2.2.2.2",
        salario = 4000.00,
        senha = "123",
        plr = 500.00
    )

    @Test
    fun deve_retornar_bonificacao() {
        val bonificacao = diretor.getBonificacao()

        assertEquals(4500.00, bonificacao)
    }

    @Test
    fun deve_retornar_true_quando_autenticar_com_senha_correta() {
        val senha = "123"

        val estaAutenticado = diretor.autentica(senha)

        assertTrue { estaAutenticado }
    }

    @Test
    fun deve_retornar_false_quando_autenticar_com_senha_errada() {
        val senha = "1234"

        val estaAutenticado = diretor.autentica(senha)

        assertFalse { estaAutenticado }
    }
}