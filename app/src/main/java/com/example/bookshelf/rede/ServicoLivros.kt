package com.example.bookshelf.rede

import com.example.bookshelf.model.LivroResposta
import retrofit2.http.GET
import retrofit2.http.Query

interface ServicoLivros {
    // Pesquisa livros com base no termo de consulta
    @GET("volumes")
    suspend fun pesquisarLivros(@Query("q") consulta: String): LivroResposta
}
