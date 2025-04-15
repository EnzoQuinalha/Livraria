package com.example.bookshelf.model

import com.google.gson.annotations.SerializedName

// Classe que representa a resposta principal da API
data class LivroResposta(
    @SerializedName("items")
    val livros: List<Livro>
)
