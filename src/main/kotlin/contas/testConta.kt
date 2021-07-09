package contas

fun main() {
    println("Bem vindo ao ByteBank!!!")

    val contaSavio = ContaPoupanca(
        titular = "Sávio",
        numero = 1
    )
    val contaLeticia = ContaCorrente(
        titular = "Leticia",
        numero = 2
    )

    contaSavio.depositar(valor = 30.00)
    contaLeticia.depositar(valor = 30.00)
    contaSavio.transfere(valor = 10.00, destino = contaLeticia)
    contaLeticia.sacar(valor = 10.00)

    println("Conta Sávio: $contaSavio")
    println("Conta Leticia: $contaLeticia")
}