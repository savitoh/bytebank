package com.github.savitoh.bytebank.contas

import com.github.savitoh.bytebank.clientes.Cliente

class ContaPoupanca(
    titular: Cliente,
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