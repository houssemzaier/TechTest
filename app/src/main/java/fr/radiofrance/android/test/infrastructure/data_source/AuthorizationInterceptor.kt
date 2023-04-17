package fr.radiofrance.android.test.infrastructure.data_source

import okhttp3.Interceptor
import okhttp3.Response

class AuthorizationInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .apply {
                addHeader("x-token", "e59800c2-7e6d-4426-98b4-8a389c189569")
            }
            .build()
        return chain.proceed(request)
    }
}
