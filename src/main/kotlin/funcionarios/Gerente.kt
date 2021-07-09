package funcionarios

class Gerente(
    nome: String,
    cpf: String,
    salario: Double,
    private val senha: String
) : Funcionario(
    nome = nome,
    cpf = cpf,
    salario = salario
) {

    fun autenticacao(senha: String) = senha == this.senha

    override fun getBonificacao() = super.getBonificacao() + salario

    override fun toString() = "funcionarios.Gerente(senha='$senha') ${super.toString()}"

}