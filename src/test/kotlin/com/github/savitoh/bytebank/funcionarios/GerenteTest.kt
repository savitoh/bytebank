package com.github.savitoh.bytebank.funcionarios

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class GerenteTest {

    private val gerente = Gerente(
        nome = "Rafael",
        cpf = "1.1.1.1",
        salario = 3000.00,
        senha = "senha"
    )

    @Test
    fun deve_retornar_bonificacao() {
        val bonificacao = gerente.getBonificacao()

        assertEquals(3000.00, bonificacao)
    }

    @Test
    fun deve_retornar_true_quando_autenticar_com_senha_correta() {
        val senha = "senha"

        val estaAutenticado = gerente.autentica(senha)

        assertTrue { estaAutenticado }
    }

    @Test
    fun deve_retornar_false_quando_autenticar_com_senha_errada() {
        val senha = "1234"

        val estaAutenticado = gerente.autentica(senha)

        assertFalse { estaAutenticado }
    }
}