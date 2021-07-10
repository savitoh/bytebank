package com.github.savitoh.bytebank.funcionarios

class Gerente(
    nome: String,
    cpf: String,
    salario: Double,
    senha: String
) : FuncionarioAdmin(
    nome = nome,
    cpf = cpf,
    salario = salario,
    senha = senha
) {

    override fun getBonificacao() = salario

}