package com.spinner.cryptocurrencies.data.remote

import okhttp3.Interceptor
import okhttp3.Response

const val HEADER_CACHE_CONTROL = "Cache-Control"
const val CACHE_DURATION = 60 * 60 * 24 // Cache duration in seconds (1 day)

class CacheInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val response = chain.proceed(chain.request())
        return response.newBuilder()
            .header(HEADER_CACHE_CONTROL, "public, max-age=$CACHE_DURATION")
            .build()
    }
}