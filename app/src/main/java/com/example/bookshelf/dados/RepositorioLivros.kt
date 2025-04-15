package com.example.bookshelf.dados

import com.example.bookshelf.model.Livro
import com.example.bookshelf.rede.FornecedorRetrofit
import com.example.bookshelf.rede.ServicoLivros

class RepositorioLivros(servicoLivros: ServicoLivros) {
    // Retorna uma lista de livros de acordo com a consulta
    suspend fun obterLivros(consulta: String): List<Livro> {
        return FornecedorRetrofit.servicoLivros.pesquisarLivros(consulta).livros
    }
}
