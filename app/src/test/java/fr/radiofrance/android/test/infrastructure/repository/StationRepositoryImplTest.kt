package fr.radiofrance.android.test.infrastructure.repository

import fr.radiofrance.android.test.domain.models.Show
import fr.radiofrance.android.test.domain.models.Station
import fr.radiofrance.android.test.infrastructure.data_source.DataSource
import fr.radiofrance.graphql.GetBrandsQuery
import fr.radiofrance.graphql.ShowsByStationQuery
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class StationRepositoryImplTest {

    private lateinit var dataSource: DataSource
    private lateinit var stationRepository: StationRepositoryImpl

    @Before
    fun setUp() {
        dataSource = mockk()
        stationRepository = StationRepositoryImpl(dataSource)
    }

    @Test
    fun `getAllStationList should return correct stations`() = runTest {
        // Given
        val brands = listOf(
            GetBrandsQuery.Brand("1", "Station 1", "Baseline 1", "Description 1"),
            GetBrandsQuery.Brand("2", "Station 2", "Baseline 2", "Description 2"),
        )
        coEvery { dataSource.getBrandList() } returns brands

        // When
        val stations = stationRepository.getAllStationList()

        // Then
        val expectedStations = listOf(
            Station("1", "Station 1", "Baseline 1", "Description 1"),
            Station("2", "Station 2", "Baseline 2", "Description 2"),
        )
        assertEquals(expectedStations, stations)
    }

    @Test
    fun `getShowListByStation should return correct shows`() = runTest {
        // Given
        val station = Station("1", "Station 1", "Baseline 1", "Description 1")
        val nodes = listOf(
            ShowsByStationQuery.Node("1", "Show 1", "StandFirst 1"),
            ShowsByStationQuery.Node("2", "Show 2", "StandFirst 2"),
        )
        coEvery { dataSource.getShowsByStation(station) } returns nodes

        // When
        val shows = stationRepository.getShowListByStation(station)

        // Then
        val expectedShows = listOf(
            Show("1", "Show 1", "StandFirst 1"),
            Show("2", "Show 2", "StandFirst 2"),
        )
        assertEquals(expectedShows, shows)
    }
}
