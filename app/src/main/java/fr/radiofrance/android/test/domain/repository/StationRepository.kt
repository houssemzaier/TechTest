package fr.radiofrance.android.test.domain.repository

import fr.radiofrance.android.test.domain.models.Show
import fr.radiofrance.android.test.domain.models.Station

interface StationRepository {
    suspend fun getAllStationList(): List<Station>
    suspend fun getShowListByStation(station: Station): List<Show>
}
