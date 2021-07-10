package com.github.savitoh.bytebank

import com.github.savitoh.bytebank.auth.Autenticavel

class SistemaInterno {

    fun entra(autenticavel: Autenticavel, senha: String) {
        if (autenticavel.autentica(senha)) {
            println("Bem vindo ao ByteBank")
        } else {
            println("Falha na autenticacao")
        }
    }
}