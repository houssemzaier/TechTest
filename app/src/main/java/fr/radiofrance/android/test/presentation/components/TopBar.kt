package fr.radiofrance.android.test.presentation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TopBar(
    shouldShowUpButton: Boolean = false,
    title: String = "",
    onUpClick: () -> Unit,
) {
    TopAppBar(
        title = {
            Text(
                text = title,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.headlineLarge,
            )
        },
        navigationIcon = {
            if (shouldShowUpButton) {
                IconButton(
                    onClick = onUpClick,
                ) {
                    Icon(
                        Icons.Filled.ArrowBack,
                        contentDescription = "Back",
                    )
                }
            }
        },
    )
}

@Preview
@Composable
fun TopBar_Prev() {
    TopBar(true, "title") {}
}
