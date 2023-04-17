package fr.radiofrance.android.test.presentation.components

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import fr.radiofrance.android.test.ComposeTestActivity
import fr.radiofrance.android.test.domain.models.Station
import org.junit.Rule
import org.junit.Test

class StationContentCardTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComposeTestActivity>()

    @Test
    fun stationContentCard_displaysCorrectText() {
        val testStation = Station(
            id = "1",
            title = "Station 1",
            baseline = "baseline 1",
            description = "description 1",
        )

        composeTestRule.setContent {
            StationContentCard(station = testStation)
        }

        // Check if the title is displayed
        composeTestRule.onNodeWithText(testStation.title).assertIsDisplayed()

        // Check if the baseline is displayed
        composeTestRule.onNodeWithText(testStation.baseline).assertIsDisplayed()

        // Check if the description is displayed
        composeTestRule.onNodeWithText(testStation.description).assertIsDisplayed()
    }
}
