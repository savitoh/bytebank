fun main() {
    println("Bem vindo ao ByteBank!!!")

    val contaSavio = Conta(titular= "Sávio", numero = 1)
    val contaLeticia = Conta(titular = "Leticia", numero = 2)

    contaSavio.depositar(valor = 30.00)
    contaSavio.transfere(valor = 10.00, destino = contaLeticia)

    println("Conta Sávio: $contaSavio")
    println("Conta Leticia: $contaLeticia")
}