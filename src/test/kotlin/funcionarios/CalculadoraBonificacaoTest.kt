package funcionarios

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class CalculadoraBonificacaoTest {

    private val analista = Analista(
        nome = "Sávio",
        cpf = "0.0.0.0",
        salario = 2000.00
    )

    private val gerente = Gerente(
        nome = "Rafael",
        cpf = "1.1.1.1",
        salario = 3000.00,
        senha = "senha"
    )

    private val diretor = Diretor(
        nome = "Marecelo",
        cpf = "2.2.2.2",
        salario = 4000.00,
        senha = "123",
        plr = 500.00
    )

    private lateinit var calculadoraBonificacao: CalculadoraBonificacao

    @BeforeEach
    internal fun setUp() {
        calculadoraBonificacao = CalculadoraBonificacao()
    }

    @Test
    fun deve_retornar_zero_quando_nao_ha_funcionario_registrado() {
        val totalBonificacoes = calculadoraBonificacao.total

        assertEquals(0.0, totalBonificacoes)
    }

    @Test
    fun deve_retornar_soma_bonficacoes_funcionarios_registrados() {
        calculadoraBonificacao.registra(analista)
        calculadoraBonificacao.registra(gerente)
        calculadoraBonificacao.registra(diretor)

        val totalBonificacoes = calculadoraBonificacao.total

        assertEquals(7700.00, totalBonificacoes)
    }
}