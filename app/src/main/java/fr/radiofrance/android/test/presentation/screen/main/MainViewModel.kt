package fr.radiofrance.android.test.presentation.screen.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.radiofrance.android.test.domain.models.Show
import fr.radiofrance.android.test.domain.models.Station
import fr.radiofrance.android.test.infrastructure.repository.StationRepositoryImpl
import fr.radiofrance.android.test.presentation.util.UiState
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: StationRepositoryImpl,
) : ViewModel() {

    private val _brandList: MutableStateFlow<UiState<List<Station>>> =
        MutableStateFlow(UiState.Loading)
    val brandList: StateFlow<UiState<List<Station>>> = _brandList

    private val _showList: MutableStateFlow<UiState<List<Show>>> = MutableStateFlow(UiState.Loading)
    val showList: StateFlow<UiState<List<Show>>> = _showList

    private val _currentStation = MutableStateFlow<Station?>(null)
    val currentStation: MutableStateFlow<Station?> = _currentStation

    fun getStation() {
        viewModelScope.launch(IO) {
            try {
                repository.getAllStationList()
                val stationList = repository.getAllStationList()
                _brandList.value = UiState.Success(stationList)

            } catch (e: Exception) {
                _brandList.value = UiState.Error(e)
            }
        }
    }

    fun getShows(station: Station) {
        viewModelScope.launch(IO) {
            try {
                val showList = repository.getShowListByStation(station)
                _showList.value = UiState.Success(showList)
            } catch (e: Exception) {
                _showList.value = UiState.Error(e)
            }
        }
    }

    fun setCurrentStation(currentStation: Station) {
        _currentStation.value = (currentStation)
    }
}
