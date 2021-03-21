package modelo

class Arvore {

    var raiz: No = No("")
    var noAtual: No = No("")

    fun inicializar(dica: String, pratoSim: String, pratoNao: String){
        raiz = No(dica)
        raiz.sim = No(pratoSim)
        raiz.nao = No(pratoNao)
    }

    val ehVazia: Boolean
        get() = raiz.valor.isEmpty()


    fun inserir(noAtual: No, dica: String, prato: String) {
        val ultimoPalpite = noAtual.valor
        noAtual.nao = No(ultimoPalpite)
        noAtual.sim = No(prato)
        noAtual.valor = dica
    }
}