package com.github.savitoh.bytebank.contas

import com.github.savitoh.bytebank.clientes.Cliente
import com.github.savitoh.bytebank.contas.ContaCorrente.CONSTS.TAXA_SAQUE


class ContaCorrente(
    titular: Cliente,
    numero: Int
) : ContaTransferivel(
    titular = titular,
    numero = numero
) {

    private object CONSTS {
        const val TAXA_SAQUE = 0.1
    }

    override fun sacar(valor: Double) {
        val valorComTaxa = valor + TAXA_SAQUE
        if (this.saldo >= valorComTaxa) {
            this.saldo -= valorComTaxa
        }
    }
}