package com.example.bookshelf.rede

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object FornecedorRetrofit {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://www.googleapis.com/books/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val servicoLivros: ServicoLivros = retrofit.create(ServicoLivros::class.java)
}
