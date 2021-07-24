package com.github.savitoh.bytebank

import com.github.savitoh.bytebank.auth.Autenticavel

class SistemaInterno {

    fun entra(
        autenticavel: Autenticavel,
        senha: String,
        resultado: (String) -> Unit = ::println,
    ) {
        if (autenticavel.autentica(senha)) resultado("Bem vindo ao BytBank")
        else resultado("Falha na autenticacao")
    }
}