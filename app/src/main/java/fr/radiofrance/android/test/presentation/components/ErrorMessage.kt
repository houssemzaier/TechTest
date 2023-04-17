package fr.radiofrance.android.test.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import fr.radiofrance.android.test.presentation.util.UiState

@Composable
fun ErrorMessage(
    modifier: Modifier,
    showListState: UiState.Error,
) {
    Box(modifier = modifier.fillMaxSize()) {
        Text(
            text = "Error: ${showListState.exception.message}",
            modifier = Modifier
                .align(Alignment.Center),
            textAlign = TextAlign.Center,
            color = Color.Red,
            fontStyle = FontStyle.Italic,
        )
    }
}
