package Questoes

fun main(args: Array<String>) {

    permutacaoParcial("you", "yuo")
    permutacaoParcial("body", "tody")
    permutacaoParcial("probably", "porbalby")
    permutacaoParcial("moon", "nmoo")
    permutacaoParcial("despite", "desptie")
    permutacaoParcial("misspellings", "mpeissngslli")

}

fun permutacaoParcial(primeiro: String, segundo: String) {
    print("$primeiro, $segundo -> ")
    println(ePermutacaoParcial(primeiro, segundo))
}

fun ePermutacaoParcial(primeiro: String, segundo: String): Boolean {
    if (segundo.length == primeiro.length) {
        if (primeiro[0] == segundo[0]) {
            val comprimentoPalavras = segundo.length
            var contagemLetras = 0
            segundo.forEachIndexed { index, c ->
                val indexePrimeiro = primeiro.indexOf(c)
                if (indexePrimeiro == -1) {
                    return false
                }
                if (index != indexePrimeiro) {
                    contagemLetras++
                }
            }
            if (comprimentoPalavras > 3) {
                if (contagemLetras < (comprimentoPalavras * (2f / 3f))) {
                    return true
                }
            } else {
                return contagemLetras > 0
            }
        }
    }
    return false
}