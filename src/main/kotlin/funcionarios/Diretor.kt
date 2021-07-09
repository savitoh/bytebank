package funcionarios

class Diretor(
    nome: String,
    cpf: String,
    salario: Double,
    private val senha: String,
    private val plr: Double
) : Funcionario(
    nome = nome,
    cpf = cpf,
    salario = salario
) {

    override fun getBonificacao() = super.getBonificacao() + salario + plr

}