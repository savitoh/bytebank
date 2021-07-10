import auth.Autenticavel
import funcionarios.FuncionarioAdmin

class SistemaInterno {

    fun entra(autenticavel: Autenticavel, senha: String) {
        if(autenticavel.autentica(senha)) {
            println("Bem vindo ao ByteBank")
        } else {
            println("Falha na autenticacao")
        }
    }
}