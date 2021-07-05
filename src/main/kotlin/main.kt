fun main() {
    println("Bem vindo ao ByteBank!!!")

    val contaSavio = Conta("Sávio", 1, 20.00)
    val contaLeticia = Conta("Leticia", 2, 30.00)
    contaSavio.transfere(10.00, contaLeticia)

    println("Conta Sávio: $contaSavio")
    println("Conta Leticia: $contaLeticia")
}