package com.github.savitoh.bytebank

import com.github.savitoh.bytebank.auth.Autenticavel
import kotlin.test.Test

internal class SistemaInternoTest {

    private object autenticavel : Autenticavel {

        const val senha = "12345"

        override fun autentica(senha: String) = this.senha == senha

    }

    private val sistemaInterno = SistemaInterno()

    @Test
    fun deve_entrar_quando_senha_correta() {
        sistemaInterno.entra(
            autenticavel = autenticavel,
            senha = autenticavel.senha,
            resultado = { println("Imprimindo com lamdda expression. $it") }
        )
    }

    @Test
    fun nao_deve_entrar_quando_senha_errada() {
        sistemaInterno.entra(autenticavel = autenticavel, senha = "failSenha") {
            println("Imprimindo com funcao anonima. $it")
        }
    }
}