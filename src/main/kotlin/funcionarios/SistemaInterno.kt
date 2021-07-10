package funcionarios

class SistemaInterno {

    fun entra(admin: FuncionarioAdmin, senha: String) {
        if(admin.autentica(senha)) {
            println("Bem vindo ao ByteBank")
        } else {
            println("Falha na autenticacao")
        }
    }
}