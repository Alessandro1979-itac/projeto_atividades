package Questoes

fun main(args: Array<String>) {

    val cabeca1 = Node(10, "mensagem-10")
    cabeca1.proximo = Node(20, "mensagem-20")
    cabeca1.proximo!!.proximo = Node(30, "mensagem-30")
    cabeca1.proximo!!.proximo!!.proximo = Node(40, "mensagem-40")
    cabeca1.proximo!!.proximo!!.proximo!!.proximo = Node(50, "mensagem-50")
    cabeca1.proximo!!.proximo!!.proximo!!.proximo!!.proximo = Node(60, "mensagem-60")

    val cabeca2 = Node(25, "mensagem-25")
    cabeca2.proximo = cabeca1.proximo!!.proximo
    cabeca2.proximo!!.proximo = cabeca1.proximo!!.proximo!!.proximo
    cabeca2.proximo!!.proximo!!.proximo = cabeca1.proximo!!.proximo!!.proximo!!.proximo
    cabeca2.proximo!!.proximo!!.proximo!!.proximo = cabeca1.proximo!!.proximo!!.proximo!!.proximo!!.proximo

    val interSecaoNo = obterNo(cabeca1, cabeca2)
    if (interSecaoNo.isNullOrBlank()) {
        println("As listas não têm interseções")
    } else {
        println("O nó da interseção é ${interSecaoNo}")
    }
}

fun obterNo(cabeca1: Node, cabeca2: Node) : String? {

    val a1 = obterContagem(cabeca1)
    val a2 = obterContagem(cabeca2)
    val b: Int

    return if (a1 > a2) {
        b = a1 - a2
        obterIntersecaoNo(b, cabeca1, cabeca2)
    } else {
        b = a2 - a1
        obterIntersecaoNo(b, cabeca2, cabeca1)
    }
}

fun obterContagem(node: Node) : Int {

    var atual: Node? = node
    var contador = 0

    while (atual != null) {
        contador++
        atual = atual.proximo
    }
    return contador
}

fun obterIntersecaoNo(d: Int, node1: Node, node2: Node) : String? {

    var k = 0
    var atual1: Node? = node1
    var atual2: Node? = node2

    while (k < d) {
        if (atual1 == null) {
            return null
        }
        atual1 = atual1.proximo
        k++
    }
    while (atual1 != null && atual2 != null) {
        if (atual1.id == atual2.id) {
            return atual1.valor
        }
        atual1 = atual1.proximo
        atual2 = atual2.proximo
    }
    return null
}