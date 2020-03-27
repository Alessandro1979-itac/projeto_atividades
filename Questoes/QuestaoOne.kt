package Questoes

fun main(args: Array<String>){
    val entrada = "User  is  not  allowed   ".toCharArray()
    substituirEspacoBranco(entrada)
    println(entrada)
    print("Size: ${entrada.size}")
}

fun substituirEspacoBranco(entrada: CharArray){
    while (entrada.contains(' ')){
        val Espaco = entrada.indexOf(' ')
        val Carta = entrada.indexOfLast { i -> i != ' ' }

        for (k in Carta downTo Espaco){
            entrada[k + 1] = entrada[k]
        }
        entrada[Espaco] = '&'
        entrada[Espaco + 1] = '3'
        entrada[Espaco + 2] = '2'
    }
}