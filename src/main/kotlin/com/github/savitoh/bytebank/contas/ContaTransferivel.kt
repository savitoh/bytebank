package com.github.savitoh.bytebank.contas

import com.github.savitoh.bytebank.clientes.Cliente
import com.github.savitoh.bytebank.contas.exceptions.SaldoInsuficienteException

abstract class ContaTransferivel(
    titular: Cliente,
    numero: Int
) : Conta(
    titular = titular,
    numero = numero
) {

    fun transfere(valor: Double, destino: ContaTransferivel) {
        if(this.saldo < valor)  {
            throw SaldoInsuficienteException("O saldo é insuficiente. Saldo atual: ${this.saldo}. Valor a ser transferido: $valor")
        }
        this.saldo -= valor
        destino.depositar(valor)
    }
}