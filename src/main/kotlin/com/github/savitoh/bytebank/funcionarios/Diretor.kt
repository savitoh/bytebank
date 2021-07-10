package com.github.savitoh.bytebank.funcionarios

class Diretor(
    nome: String,
    cpf: String,
    salario: Double,
    senha: String,
    private val plr: Double
) : FuncionarioAdmin(
    nome = nome,
    cpf = cpf,
    salario = salario,
    senha = senha
) {

    override fun getBonificacao() = salario + plr

}