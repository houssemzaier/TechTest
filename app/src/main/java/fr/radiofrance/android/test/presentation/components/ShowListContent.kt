package fr.radiofrance.android.test.presentation.components

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import fr.radiofrance.android.test.domain.models.Show

@Composable
fun ShowListContent(
    showList: List<Show>,
    modifier: Modifier = Modifier,
) {
    BoxWithConstraints(
        modifier = modifier,
    ) {
        val columns = when {
            maxWidth < 600.dp -> 2
            maxWidth < 900.dp -> 3
            else -> 4
        }
        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(columns),
        ) {
            itemsIndexed(
                items = showList,
                key = { _, show ->
                    show.id
                },
            ) { _, show ->
                ShowContent(show)
            }
        }
    }
}
