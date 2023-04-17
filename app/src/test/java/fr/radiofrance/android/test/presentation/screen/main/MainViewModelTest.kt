package fr.radiofrance.android.test.presentation.screen.main

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import fr.radiofrance.android.test.domain.models.Show
import fr.radiofrance.android.test.domain.models.Station
import fr.radiofrance.android.test.infrastructure.repository.StationRepositoryImpl
import fr.radiofrance.android.test.presentation.util.UiState
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class MainViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: MainViewModel

    private val stationRepository: StationRepositoryImpl = mockk()

    @Before
    fun setUp() {
        viewModel = MainViewModel(repository = stationRepository)
    }


    @Test
    fun `getStation should set UiState Success when successful`() {
        val stations = listOf(
            Station(
                id = "1",
                title = "Station 1",
                baseline = "baseline 1",
                description = "description 1",
            ),
            Station(
                id = "2",
                title = "Station 2",
                baseline = "baseline 2",
                description = "description 2",
            ),
        )

        coEvery { stationRepository.getAllStationList() } returns stations

        viewModel.getStation()

        coVerify { stationRepository.getAllStationList() }
        assertEquals(UiState.Success(stations), viewModel.brandList.value)
    }

    @Test
    fun `getStation should set UiState Error when error occurs`() {
        val exception = Exception("Error fetching stations")

        coEvery { stationRepository.getAllStationList() } throws exception

        viewModel.getStation()

        coVerify { stationRepository.getAllStationList() }
        assertEquals(UiState.Error(exception), viewModel.brandList.value)
    }

    @Test
    fun `getShows should set UiState Success when successful`() {
        val station = Station(
            id = "1",
            title = "Station 1",
            baseline = "baseline 1",
            description = "description 1",
        )
        val shows = listOf(
            Show(id = "1", title = "Show 1", standFirst = "standFirst 1 "),
            Show(id = "2", title = "Show 2", standFirst = "standFirst 2 "),
        )

        coEvery { stationRepository.getShowListByStation(station) } returns shows

        viewModel.getShows(station)

        coVerify { stationRepository.getShowListByStation(station) }
        assertEquals(UiState.Success(shows), viewModel.showList.value)
    }

    @Test
    fun `getShows should set UiState Error when error occurs`() {
        val station = Station(
            id = "1",
            title = "Station 1",
            baseline = "baseline 1",
            description = "description 1",
        )
        val exception = Exception("Error fetching shows")

        coEvery { stationRepository.getShowListByStation(station) } throws exception

        viewModel.getShows(station)

        coVerify { stationRepository.getShowListByStation(station) }
        assertEquals(UiState.Error(exception), viewModel.showList.value)
    }

    @Test
    fun `setCurrentStation should set currentStation`() {
        val station = Station(
            id = "1",
            title = "Station 1",
            baseline = "baseline 1",
            description = "description 1",
        )

        viewModel.setCurrentStation(station)

        assertEquals(station, viewModel.currentStation.value)
    }
}
