package com.github.savitoh.bytebank.funcionarios

class CalculadoraBonificacao {

    var total: Double = 0.0
        private set

    fun registra(funcionario: Funcionario) {
        this.total += funcionario.getBonificacao()
    }
}