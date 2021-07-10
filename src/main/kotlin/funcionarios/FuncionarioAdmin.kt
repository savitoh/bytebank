package funcionarios

import auth.Autenticavel

abstract class FuncionarioAdmin(
    nome: String,
    cpf: String,
    salario: Double,
    val senha: String
) : Funcionario(
    nome = nome,
    cpf = cpf,
    salario = salario
), Autenticavel {

    override fun autentica(senha: String) = senha == this.senha

}