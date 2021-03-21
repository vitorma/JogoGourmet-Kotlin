package modelo

class No(var valor: String) {

    var sim: No? = null
    var nao: No? = null
    val ehPrato: Boolean
        get() = sim == null && nao == null

}