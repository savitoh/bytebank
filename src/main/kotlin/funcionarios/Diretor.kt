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

    fun autentica(senha: String) = senha == this.senha

    override fun getBonificacao() =  salario + plr

}