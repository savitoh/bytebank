package contas

import contas.ContaCorrente.TAXAS.SAQUE


class ContaCorrente(
    titular: String,
    numero: Int
) : Conta(
    titular = titular,
    numero = numero
) {

    private object TAXAS {
        const val SAQUE = 0.1
    }

    override fun sacar(valor: Double) {
        val valorComTaxa = valor + SAQUE
        if (this.saldo >= valorComTaxa) {
            this.saldo -= valorComTaxa
        }
    }
}