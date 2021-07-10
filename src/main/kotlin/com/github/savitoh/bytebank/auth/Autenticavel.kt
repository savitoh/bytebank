package com.github.savitoh.bytebank.auth

interface Autenticavel {

    fun autentica(senha: String): Boolean

}