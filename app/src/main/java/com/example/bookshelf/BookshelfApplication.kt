package com.example.bookshelf

import android.app.Application
import com.example.bookshelf.dados.RepositorioLivros
import com.example.bookshelf.rede.FornecedorRetrofit

class BookshelfApplication : Application() {
    // Repositório pronto para ser usado em toda a aplicação
    val repositorio: RepositorioLivros by lazy {
        RepositorioLivros(FornecedorRetrofit.servicoLivros)
    }
}
