package com.github.savitoh.bytebank.contas

class ContaPoupanca(
    titular: String,
    numero: Int
) : ContaTransferivel(
    titular = titular,
    numero = numero
) {
    override fun sacar(valor: Double) {
        if (this.saldo > valor) {
            this.saldo -= valor
        }
    }
}