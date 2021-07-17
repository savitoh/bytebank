package com.github.savitoh.bytebank.contas

import com.github.savitoh.bytebank.auth.Autenticavel
import com.github.savitoh.bytebank.clientes.Cliente

abstract class Conta(
    private val titular: Cliente,
    private val numero: Int
) : Autenticavel by titular {
    var saldo = 0.0
        protected set

    companion object {
        var total = 0
            private set
    }

    init {
        total++
    }

    fun getTotal() = total

    fun depositar(valor: Double) {
        if (valor > 0) {
            this.saldo += valor
        }
    }

    abstract fun sacar(valor: Double)

    override fun toString() =
        "com.github.savitoh.bytebank.contas.Conta(titular='$titular', numero=$numero, saldo=$saldo)"


}