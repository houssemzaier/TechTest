package fr.radiofrance.android.test.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.radiofrance.android.test.domain.models.Show

@Composable
fun ShowContent(show: Show, modifier: Modifier = Modifier) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(16.dp),
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp),
        ) {
            Text(
                text = show.title,
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth(),
            )
            if (show.standFirst.isNotBlank()) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = show.standFirst,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodyMedium,
                    fontStyle = FontStyle.Italic,
                )
            }
        }
    }
}

@Preview
@Composable
fun ShowContentCard_Prev() {
    val show = Show(
        id = "01287fbf-f5d5-4801-8ae0-d7ace680214d_56",
        title = "Willy Rovelli",
        standFirst = "Tout ce que Willy Rovelli a retenu de l'actualité, avec ironie, humour et bonne humeur.",
    )
    ShowContent(show)
}
