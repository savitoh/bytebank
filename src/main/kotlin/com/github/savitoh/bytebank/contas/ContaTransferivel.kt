package com.github.savitoh.bytebank.contas

abstract class ContaTransferivel(
    titular: String,
    numero: Int
) : Conta(
    titular = titular,
    numero = numero
) {

    fun transfere(valor: Double, destino: ContaTransferivel): Boolean {
        if (this.saldo >= valor) {
            this.saldo -= valor
            destino.depositar(valor)
            return true
        }
        return false
    }
}