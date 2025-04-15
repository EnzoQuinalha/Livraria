package com.example.bookshelf.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.bookshelf.dados.RepositorioLivros

/**
 * Fábrica de ViewModel que injeta o RepositórioLivros no LivrosViewModel.
 */
class FabricaLivrosViewModel(
    private val repositorioLivros: RepositorioLivros
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LivrosViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return LivrosViewModel(repositorioLivros) as T
        }
        throw IllegalArgumentException("Classe ViewModel desconhecida.")
    }
}
