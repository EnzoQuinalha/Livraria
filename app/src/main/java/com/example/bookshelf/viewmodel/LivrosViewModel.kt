package com.example.bookshelf.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookshelf.dados.RepositorioLivros
import com.example.bookshelf.model.Livro
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

sealed class EstadoUILivros {
    object Carregando : EstadoUILivros()
    data class Sucesso(val livros: List<Livro>) : EstadoUILivros()
    data class Erro(val mensagem: String) : EstadoUILivros()
}

class LivrosViewModel(private val repositorio: RepositorioLivros) : ViewModel() {

    private val _estado = MutableStateFlow<EstadoUILivros>(EstadoUILivros.Carregando)
    val estado: StateFlow<EstadoUILivros> = _estado

    init {
        buscarLivros("android") // Termo de busca inicial
    }

    fun buscarLivros(termo: String) {
        viewModelScope.launch {
            _estado.value = EstadoUILivros.Carregando
            try {
                val resultado = repositorio.obterLivros(termo)
                _estado.value = EstadoUILivros.Sucesso(resultado)
            } catch (e: Exception) {
                _estado.value = EstadoUILivros.Erro("Erro ao carregar livros: ${e.message}")
            }
        }
    }
}
