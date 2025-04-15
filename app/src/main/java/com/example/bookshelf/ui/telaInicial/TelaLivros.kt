package com.example.bookshelf.ui.telaInicial

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.bookshelf.viewmodel.LivrosViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.bookshelf.viewmodel.EstadoUILivros

@Composable
fun TelaLivros(viewModel: LivrosViewModel) {
    val estadoUi = viewModel.estado.collectAsStateWithLifecycle()

    when (val estado = estadoUi.value) {
        is EstadoUILivros.Carregando -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        is EstadoUILivros.Erro -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = estado.mensagem,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }

        is EstadoUILivros.Sucesso -> {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Total de livros: ${estado.livros.size}")

                estado.livros.forEach { livro ->
                    Text(text = livro.informacoesVolume.title)
                }
            }
        }

    }
}



@Composable
fun ListaLivrosGrid(listaLivros: List<com.example.bookshelf.model.Livro>) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 128.dp),
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        items(listaLivros) { livro ->
            Column(
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                val urlImagem = livro.informacoesVolume.imageLinks?.capaFormatada

                Text(
                    text = urlImagem ?: "Sem imagem",
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(4.dp)
                )
                Text(
                    text = livro.informacoesVolume.title,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
        }

    }
}
