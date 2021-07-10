package com.github.savitoh.bytebank

import com.github.savitoh.bytebank.auth.Autenticavel

class Cliente(
    private val nome: String,
    private val cpf: String,
    private val senha: String
) : Autenticavel {

    override fun autentica(senha: String) = senha == this.senha

}