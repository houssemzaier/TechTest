package fr.radiofrance.android.test.infrastructure.repository

import fr.radiofrance.android.test.domain.models.Show
import fr.radiofrance.android.test.domain.models.Station
import fr.radiofrance.android.test.domain.repository.StationRepository
import fr.radiofrance.android.test.infrastructure.data_source.DataSource
import fr.radiofrance.graphql.GetBrandsQuery
import fr.radiofrance.graphql.ShowsByStationQuery
import javax.inject.Inject


class StationRepositoryImpl @Inject constructor(
    private val dataSource: DataSource,
) : StationRepository {
    private companion object {

        private fun GetBrandsQuery.Brand.toStation(): Station = Station(
            id = id,
            title = title,
            baseline = baseline.orEmpty(),
            description = description.orEmpty(),
        )

        private fun ShowsByStationQuery.Node.toShow(): Show = Show(
            id = this.id,
            title = this.title,
            standFirst = this.standFirst.orEmpty(),
        )
    }


    override suspend fun getAllStationList(): List<Station> =
        dataSource.getBrandList().map {
            it.toStation()
        }

    override suspend fun getShowListByStation(station: Station): List<Show> =
        dataSource.getShowsByStation(station).map {
            it.toShow()
        }
}
