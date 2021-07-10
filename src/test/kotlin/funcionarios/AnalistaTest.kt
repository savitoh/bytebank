package funcionarios

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class AnalistaTest {

    private val analista = Analista(
        nome = "Sávio",
        cpf = "0.0.0.0",
        salario = 2000.00
    )

    @Test
    fun deve_retornar_bonificacao() {
        val bonificacao = analista.getBonificacao()

        assertEquals(200.00, bonificacao)
    }
}
