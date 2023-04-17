package fr.radiofrance.android.test.infrastructure.data_source

import android.util.Log
import com.apollographql.apollo3.ApolloClient
import fr.radiofrance.android.test.domain.models.Station
import fr.radiofrance.graphql.GetBrandsQuery
import fr.radiofrance.graphql.ShowsByStationQuery
import fr.radiofrance.graphql.type.StationsEnum
import javax.inject.Inject

class DataSource @Inject constructor(
    private val apolloClient: ApolloClient,
) {
    private companion object {
        private const val TAG = "StationRepository"
        private fun Station.toStationsEnum(): StationsEnum = StationsEnum.knownValues().first {
            it.rawValue == this.id
        }
    }

    suspend fun getBrandList(): List<GetBrandsQuery.Brand> {
        val query = GetBrandsQuery()
        val response = apolloClient.query(query).execute()
        return if (response.hasErrors()) {
            Log.d(TAG, "Error: ${response.errors}")
            throw IllegalStateException("")
        } else {
            val brands = response.data?.brands
            brands?.mapNotNull { brand: GetBrandsQuery.Brand? ->
                Log.d(
                    TAG,
                    "Brand: ${brand.toString()}",
                )
                brand
            }.orEmpty()
        }
    }


    suspend fun getShowsByStation(station: Station): List<ShowsByStationQuery.Node> {
        val query = ShowsByStationQuery(station.toStationsEnum())
        val response = apolloClient.query(query).execute()

        return if (response.hasErrors()) {
            Log.d(TAG, "Error: ${response.errors}")
            throw IllegalStateException("getShowsByStation hasErrors!")
        } else {
            val shows = response.data?.shows
            shows?.edges?.mapNotNull { edge: ShowsByStationQuery.Edge? ->
                edge?.node
            }.orEmpty()
        }
    }
}
