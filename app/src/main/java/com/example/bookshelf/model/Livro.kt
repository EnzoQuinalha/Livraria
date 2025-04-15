package com.example.bookshelf.model

import com.google.gson.annotations.SerializedName

data class Livro(
    @SerializedName("volumeInfo")
    val informacoesVolume: InformacoesVolume
)

data class InformacoesVolume(
    val title: String,
    val authors: List<String>?,
    val imageLinks: LinksImagem?
) {


    // Propriedade derivada: retorna a URL da miniatura (capa do livro)
    val imagemCapa: String?
        get() = imageLinks?.miniatura
}

data class LinksImagem(
    @SerializedName("thumbnail")
    val miniatura: String
) {
    val capaFormatada: String
        get() = miniatura.replace("http://", "https://")
}

