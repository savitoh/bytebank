package funcionarios

open class Funcionario(
    private val nome: String,
    private val cpf: String,
    val salario: Double
) {

    open fun getBonificacao() = salario * 0.1

    override fun toString() = "Funcionário(nome='$nome', cpf='$cpf', salário=$salario)"

}