package funcionarios

abstract class Funcionario(
    private val nome: String,
    private val cpf: String,
    val salario: Double
) {

    abstract fun getBonificacao() : Double

    override fun toString() = "Funcionário(nome='$nome', cpf='$cpf', salário=$salario)"

}