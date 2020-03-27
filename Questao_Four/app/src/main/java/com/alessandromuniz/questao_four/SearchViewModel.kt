package com.alessandromuniz.questao_four

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SearchViewModel : ViewModel() {

    val minhaLista: MutableLiveData<List<String>> = MutableLiveData()

    private val mWordService = WordService()

    fun pesquisar(query: String){
        minhaLista.value = mWordService.getWords(query)
    }

    fun getAll(){
        minhaLista.value = mWordService.getAll()
    }
}