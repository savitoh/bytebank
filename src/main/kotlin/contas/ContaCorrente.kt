package contas

const val TAXA_SAQUE = 0.1

class ContaCorrente(
    titular: String,
    numero: Int
) : Conta(
    titular = titular,
    numero = numero
) {
    override fun sacar(valor: Double) {
        val valorComTaxa = valor + TAXA_SAQUE
        if(this.saldo >= valorComTaxa) {
            this.saldo -= valorComTaxa
        }
    }
}