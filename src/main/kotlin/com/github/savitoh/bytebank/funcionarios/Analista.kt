package com.github.savitoh.bytebank.funcionarios

class Analista(
    nome: String,
    cpf: String,
    salario: Double
) : Funcionario(
    nome = nome,
    cpf = cpf,
    salario = salario
) {
    override fun getBonificacao() = salario * 0.1
}