package Questoes

fun main(args: Array<String>) {
    verifiqueErrosDigitacao("pale", "ple")
    verifiqueErrosDigitacao("pale", "bales")
    verifiqueErrosDigitacao("pales", "pale")
    verifiqueErrosDigitacao("pale", "bake")
    verifiqueErrosDigitacao("pale", "tale")
    verifiqueErrosDigitacao("pales", "case")
}

fun verifiqueErrosDigitacao(primeiro: String, segundo: String) {
    print("$primeiro, $segundo -> ")
    println(temUmErroDigitacao(primeiro, segundo))

}

fun temUmErroDigitacao(primeiro: String, segundo: String): Boolean {
    if (primeiro == segundo) return false
    var contador = 0
    var segundoAuxiliar = segundo
    var primeiroAuxiliar = primeiro
    when {
        primeiro.length == segundo.length -> {
            primeiro.forEachIndexed { index, c ->
                if (segundo[index] != c) {
                    contador++
                }
            }
        }
        primeiro.length > segundo.length -> {
            var diffLength = primeiro.length - segundo.length
            while (diffLength > 0) {
                segundoAuxiliar += " "
                diffLength--
            }
            primeiro.forEachIndexed { index, c ->
                if (c != segundoAuxiliar[index]) {
                    segundoAuxiliar = segundoAuxiliar.substring(0, index) + c + segundoAuxiliar.substring(index, segundoAuxiliar.length - 1)
                    contador++
                }
            }
        }
        else -> {
            var diffLength = segundo.length - primeiro.length
            while (diffLength > 0) {
                primeiroAuxiliar += " "
                diffLength--
            }
            segundo.forEachIndexed { index, c ->
                if (c != primeiroAuxiliar[index]) {
                    primeiroAuxiliar = primeiroAuxiliar.substring(0, index) + c + primeiroAuxiliar.substring(index, primeiroAuxiliar.length - 1)
                    contador++
                }
            }
        }
    }
    return contador == 1
}