package fr.radiofrance.android.test.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.radiofrance.android.test.domain.models.Station

@Composable
fun StationContentCard(
    station: Station,
    modifier: Modifier = Modifier,
    onClick: (Station) -> Unit = {},
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(16.dp),
        onClick = { onClick(station) },
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = station.title,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
            )


            if (station.baseline.isNotBlank()) {
                Text(
                    text = station.baseline,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(top = 4.dp),
                )
            }

            if (station.description.isBlank().not())
                Text(
                    text = station.description,
                    style = MaterialTheme.typography.bodySmall,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(
                        top = 8.dp,
                        end = 16.dp,
                        start = 16.dp,
                    ),
                )
        }
    }
}


@Preview(name = "Phone Preview", widthDp = 360, heightDp = 640)
@Preview(name = "Small Tablet Preview", widthDp = 600, heightDp = 1024)
@Preview(name = "Large Tablet Preview", widthDp = 800, heightDp = 1280)
@Composable
fun StationContentCard_Prev() {
    val station = Station(
        id = "FRANCEINTER",
        title = "France Inter",
        baseline = "Le direct de France Inter",
        description = "Joyeuse, savante et populaire, France Inter est la radio généraliste de service public",
    )

    StationContentCard(station)
}
