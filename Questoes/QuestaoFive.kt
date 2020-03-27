package Questoes

fun main(args: Array<String>) {

    val cabeca = Node(1, "mensagem-1")
    cabeca.proximo = Node(2, "mensagem-2")
    cabeca.proximo!!.proximo = Node(3,"mensagem-3")
    cabeca.proximo!!.proximo!!.proximo = Node(4,"mensagem-2")
    cabeca.proximo!!.proximo!!.proximo!!.proximo = Node(5,"mensagem-4")
    cabeca.proximo!!.proximo!!.proximo!!.proximo!!.proximo = Node(6,"mensagem-2")
    println("\nListar antes de remover duplicadas ${imprimirLista(cabeca)}")
    excluirDuplicada(cabeca)
    println("\nListar após remover duplicadas ${imprimirLista(cabeca)}")

}

data class Node(val id: Int, val valor: String) {
    var proximo: Node? = null
}

fun excluirDuplicada(head: Node?) {

    val hashSet = hashSetOf<String>()
    var atual = head
    var anterior: Node? = null

    while (atual != null) {
        val valor = atual.valor

        if (hashSet.contains(valor)){
            anterior!!.proximo = atual.proximo
        } else {
            hashSet.add(valor)
            anterior = atual
        }
        atual = atual.proximo
    }
}

fun imprimirLista(head: Node?) {

    var headAux = head
    while (headAux != null) {
        print("${headAux.valor}, ")
        headAux = headAux.proximo
    }
}