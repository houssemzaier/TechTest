package fr.radiofrance.android.test.infrastructure

import com.apollographql.apollo3.ApolloClient
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import fr.radiofrance.android.test.domain.repository.StationRepository
import fr.radiofrance.android.test.infrastructure.data_source.ApolloClientFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoriesHiltModule {

    companion object {
        @Singleton
        @Provides
        fun providesApolloClient(factory: ApolloClientFactory): ApolloClient = factory.create()

    }

    @Singleton
    @Binds
    abstract fun bindsStationRepository(impl: StationRepository): StationRepository

}
