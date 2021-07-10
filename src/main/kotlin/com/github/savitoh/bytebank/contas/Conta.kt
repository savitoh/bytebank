package com.github.savitoh.bytebank.contas

abstract class Conta(
    private val titular: String,
    private val numero: Int
) {
    var saldo = 0.0
        protected set

    fun depositar(valor: Double) {
        if (valor > 0) {
            this.saldo += valor
        }
    }

    abstract fun sacar(valor: Double)

    override fun toString() = "com.github.savitoh.bytebank.contas.Conta(titular='$titular', numero=$numero, saldo=$saldo)"


}