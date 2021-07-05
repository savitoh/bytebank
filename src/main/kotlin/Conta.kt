class Conta(private val titular: String, private val numero: Int, private var saldo: Double) {

    fun depositar(valor: Double) {
        this.saldo += valor
    }

    fun sacar(valor: Double) {
        if(this.saldo >= valor)  {
            this.saldo -= valor
        }
    }

    fun transfere(valor: Double, destino: Conta) : Boolean {
        if(this.saldo >= valor) {
            this.saldo -= valor
            destino.depositar(valor)
            return true
        }
        return false
    }

    override fun toString(): String {
        return "Conta(titular='$titular', numero=$numero, saldo=$saldo)"
    }


}