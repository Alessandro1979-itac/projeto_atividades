package com.alessandromuniz.questao_four

class WordService {

    private val wordList = arrayListOf("Uniforme", "Jaqueta", "Shampoo", "Hidratante", "Escova", "Perfume", "Creme",
        "Passaporte", "Guia", "Passagens", "Ingressos", "Mapa", "Carteira", "Identidade", "Dinheiro", "Cuecas",
        "Receitas", "Analgésicos", "Antissépticos", "Protetor", "Manteiga", "Curativos", "Absorvente", "Macarrão", "Pão",
        "Cintos", "Sapatos", "Joias", "Bolsas", "Chinelos", "Chapéu", "Bermudas", "Regatas", "Meias",
        "Tablet", "Smartphone", "Fone", " MP3", "Carregadores", "Coversor", "Pendrive", "Mascara",
        "Banheira", "Suporte", "Assento", "Termômetro", "Brinquedos", "Trocador", "Toalhas", "Fraldas", "Ofurô", "Almofada",
        "Garrafa", "Sabonete", "Colônia", "Oléo", "Cotonetes", "Algodão", "Lenços", "Álcool",
        "Condicionador", "Hidratante", "Chupetas", "Aspirador", "Mordedor", "Travessiro", "Trocador", "Canguru",
        "Edredons", "Cueiros", "Mantas", "Mosquiteiro", "Cabide", "Ninho", "Macacão", "Sapatinhos",
        "Luvas", "Toucas", "Mamadeiras", "Aquecedor", "Esterilizador", "Pinça", "Pratos", "Babadouros",
        "Alimentador", "Café", "Cereais", "Achocolatado", "Açúcar", "Suco", "Adoçante", "Torradas",
        "Atum", "Azeitonas", "Carne", "Frango", "Peixe", "Iorgute", "Queigos", "Requeijão", "mantegia",
        "Presunto", "Cebola", "Batata", "Alface", "Tomate", "Cenoura", "Espinafre",
        "Feijão", "Pipoca", "Maisena", "Vinagre", "Fósforo")

    fun getWords(query: String) = wordList.filter { validarPalavra(query, it) }

    fun getAll() = wordList

    private fun validarPalavra(query: String, word: String): Boolean {

        if (query == word) return true

        var cont = 0

        if (permutacaoParcial(query, word)){
            cont++
        }
        if (temErroDigitacao(query, word)) {
            cont++
        }
        return cont == 1
    }

    private fun permutacaoParcial(primeiro: String, segundo: String): Boolean {

        if (segundo.length == primeiro.length) {
            if (primeiro[0] == segundo[0]) {

                val comp_Palavras = segundo.length
                var cont_Letras = 0
                if (primeiro[0] != segundo[0]) {
                    return false
                }
                segundo.forEachIndexed { index, c ->
                    val index_Primeiro = primeiro.indexOf(c)
                    if (index_Primeiro == -1) {
                        return false
                    }
                    if (index != index_Primeiro) {
                        cont_Letras++
                    }
                }
                if (comp_Palavras > 3) {
                    if (cont_Letras < (comp_Palavras * (2f / 3f))) {
                        return true
                    }
                } else {
                    return cont_Letras > 0
                }
            }
        }
        return false
    }

    private fun temErroDigitacao(primeiro: String, segundo: String): Boolean {

        if (primeiro == segundo) return false

        var cont = 0
        var auxSegundo = segundo
        var auxPrimeiro = primeiro
        when {
            primeiro.length == segundo.length -> {
                primeiro.forEachIndexed { index, c ->
                    if (segundo[index] != c) {
                        cont++
                    }
                }
            }
            primeiro.length > segundo.length -> {
                var comprimento = primeiro.length - segundo.length
                while (comprimento > 0 ) {
                    auxSegundo += " "
                    comprimento--
                }
                primeiro.forEachIndexed { index, c ->
                    if (c != auxSegundo[index]) {
                        auxSegundo = auxSegundo.substring(0, index) + c + auxSegundo.substring(index, auxSegundo.length - 1)
                        comprimento++
                    }
                }
            }
            else -> {
                var comprimento = segundo.length - primeiro.length
                while (comprimento > 0) {
                    auxPrimeiro += " "
                    comprimento--
                }
                segundo.forEachIndexed { index, c ->
                    if (c != auxPrimeiro[index]) {
                        auxPrimeiro = auxPrimeiro.substring(0, index) + c + auxPrimeiro.substring(index, auxPrimeiro.length - 1)
                        comprimento++
                    }
                }
            }
        }
        return cont == 1
    }
}