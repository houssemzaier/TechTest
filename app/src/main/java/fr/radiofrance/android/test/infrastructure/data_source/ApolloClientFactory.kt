package fr.radiofrance.android.test.infrastructure.data_source

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.network.okHttpClient
import okhttp3.OkHttpClient
import javax.inject.Inject

class ApolloClientFactory @Inject constructor() {
    fun create(): ApolloClient = ApolloClient.Builder()
        .serverUrl("https://openapi.radiofrance.fr/v1/graphql")
        .okHttpClient(
            OkHttpClient.Builder()
                .addInterceptor(AuthorizationInterceptor())
                .build(),
        )
        .build()
}
