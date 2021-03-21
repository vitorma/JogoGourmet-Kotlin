
import modelo.Arvore
import modelo.No
import javax.swing.JOptionPane

class Game {
    private var arvoreGourmet = Arvore()
    private var continuarJogando = true

    private fun polularJogo() {
        arvoreGourmet.inicializar("Massa","Macarrão","Bolo de chocolate")
    }

    fun iniciar() {
        if (arvoreGourmet.ehVazia) {
            polularJogo()
        }
        val finalizarJogo = exibeInicio() == JOptionPane.CLOSED_OPTION

        if (finalizarJogo) {
            continuarJogando = false
        }
        arvoreGourmet.noAtual = arvoreGourmet.raiz
        while (continuarJogando) {
            palpite(arvoreGourmet.raiz)
        }
    }

    private fun palpite(no: No?) {
        val pergunta = "O prato que você pensou é " + no!!.valor + "?"
        val answer = JOptionPane.showConfirmDialog(null, pergunta, "Confirm", JOptionPane.YES_NO_OPTION)
        if (answer == JOptionPane.YES_OPTION) {
            if(arvoreGourmet.noAtual.ehPrato) {
                acabou()
            }
            arvoreGourmet.noAtual = arvoreGourmet.noAtual.sim!!
            palpite(arvoreGourmet.noAtual)
        }
        else if (answer == JOptionPane.NO_OPTION) {
            if(arvoreGourmet.noAtual.nao == null) {
                solicitaInclusao(arvoreGourmet.noAtual)
                iniciar()
            }
            arvoreGourmet.noAtual = arvoreGourmet.noAtual.nao!!
            palpite(arvoreGourmet.noAtual)

        }
    }

    private fun exibeInicio(): Int {
        return JOptionPane.showOptionDialog(
            null,
            "Pense em um prato que gosta",
            "Jogo Gourmet by Vitor Morato",
            JOptionPane.INFORMATION_MESSAGE,
            JOptionPane.QUESTION_MESSAGE,
            null,
            arrayOf<Any>("Ok"),
            null,
        )
    }

    private fun acabou() {
        JOptionPane.showMessageDialog(null, "Acertei de novo!")
        iniciar()
    }

    private fun solicitaInclusao(no: No) {
        val prato = JOptionPane.showInputDialog("Qual prato você pensou?")
        val valor = JOptionPane.showInputDialog(prato + " é _________ mas " + no.valor + " não.")
        arvoreGourmet.inserir(no, valor, prato)
    }
}

fun main() = Game().iniciar()