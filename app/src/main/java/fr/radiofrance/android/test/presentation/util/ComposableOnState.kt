package fr.radiofrance.android.test.presentation.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import fr.radiofrance.android.test.presentation.components.ErrorMessage
import fr.radiofrance.android.test.presentation.components.Loading

@Composable
fun <T> ComposableOnState(
    state: UiState<T>,
    modifier: Modifier,
    contentWhenSuccess: @Composable (data: T) -> Unit,
) {
    when (state) {
        is UiState.Loading -> Loading(modifier)

        is UiState.Error -> ErrorMessage(modifier, state)

        is UiState.Success -> contentWhenSuccess(state.data)
    }
}
