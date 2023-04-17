package fr.radiofrance.android.test.presentation.components

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.radiofrance.android.test.domain.models.Station
import fr.radiofrance.android.test.infrastructure.repository.StationRepositoryStub
import kotlinx.coroutines.launch

@Composable
fun StationListContent(
    stations: List<Station>,
    modifier: Modifier = Modifier,
    onClick: (Station) -> Unit,
) {
    BoxWithConstraints(
        modifier = modifier,
    ) {
        val columns = when {
            maxWidth < 600.dp -> 1
            maxWidth < 900.dp -> 2
            else -> 3
        }
        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(columns),
        ) {
            itemsIndexed(
                items = stations,
                key = { _, station ->
                    station.id
                },
            ) { _, show ->
                StationContentCard(show, Modifier, onClick)
            }
        }
    }
}

@Preview(name = "Phone Preview", widthDp = 360, heightDp = 640)
@Preview(name = "Small Tablet Preview", widthDp = 600, heightDp = 1024)
@Preview(name = "Large Tablet Preview", widthDp = 800, heightDp = 1280)
@Composable
private fun StationContentCardList_PrevPhone() {
    val coroutineScope = rememberCoroutineScope()
    var stationList by remember { mutableStateOf(emptyList<Station>()) }

    LaunchedEffect(Unit) {
        coroutineScope.launch {
            stationList = StationRepositoryStub().getAllStationList()
        }
    }

    StationListContent(stationList) {}

}

