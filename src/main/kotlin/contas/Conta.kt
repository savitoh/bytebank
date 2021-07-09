package contas

open class Conta(
    private val titular: String,
    private val numero: Int
) {
    private var saldo = 0.0

    fun depositar(valor: Double) {
        if (valor > 0) {
            this.saldo += valor
        }
    }

    open fun sacar(valor: Double) {
        if (this.saldo >= valor) {
            this.saldo -= valor
        }
    }

    fun transfere(valor: Double, destino: Conta): Boolean {
        if (this.saldo >= valor) {
            this.saldo -= valor
            destino.depositar(valor)
            return true
        }
        return false
    }

    override fun toString() = "contas.Conta(titular='$titular', numero=$numero, saldo=$saldo)"


}