package funcionarios

fun testFuncionarios() {
    val savio = Funcionario(
        nome = "Sávio",
        cpf = "0.0.0.0",
        salario = 2000.00
    )
    println("$savio")

    val rafael = Gerente(
        nome = "Rafael",
        cpf = "1.1.1.1",
        salario = 3000.00,
        senha = "senha"
    )

    val marcelo = Diretor(
        nome = "Marecelo",
        cpf = "2.2.2.2",
        salario = 4000.00,
        senha = "123",
        plr = 500.00
    )

    val calculadora = CalculadoraBonificacao()
    calculadora.registra(savio)
    calculadora.registra(rafael)
    calculadora.registra(marcelo)

    println("Total bonificacao: ${calculadora.total}")
}