package com.example.bookshelf

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bookshelf.ui.telaInicial.TelaLivros
import com.example.bookshelf.ui.theme.BookshelfTheme
import com.example.bookshelf.viewmodel.FabricaLivrosViewModel
import com.example.bookshelf.viewmodel.LivrosViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BookshelfTheme {
                val viewModel: LivrosViewModel = viewModel(
                    factory = FabricaLivrosViewModel(
                        (application as BookshelfApplication).repositorio
                    )
                )

                TelaLivros(viewModel = viewModel)
            }
        }
    }
}
