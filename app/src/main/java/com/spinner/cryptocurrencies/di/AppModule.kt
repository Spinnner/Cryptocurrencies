package com.spinner.cryptocurrencies.di

import android.content.Context
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.spinner.cryptocurrencies.common.Constants
import com.spinner.cryptocurrencies.data.remote.CacheInterceptor
import com.spinner.cryptocurrencies.data.remote.CoingeckoApi
import com.spinner.cryptocurrencies.data.repository.CoinRepositoryImpl
import com.spinner.cryptocurrencies.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.Cache
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApplicationContext(@ApplicationContext appContext: Context) = appContext

    @Provides
    @Singleton
    fun provideOkHttpClient(context: Context): OkHttpClient {
        val cacheSize = 10 * 1024 * 1024 // 10 MB
        val cache = Cache(context.cacheDir, cacheSize.toLong())
        val interceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .addNetworkInterceptor(CacheInterceptor())
            .cache(cache)
            .build()
    }

    @Provides
    @Singleton
    fun providePaprikaApi(client: OkHttpClient): CoingeckoApi {
        val networkJson = Json { ignoreUnknownKeys = true }

        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(client)
            .addConverterFactory(networkJson.asConverterFactory("application/json".toMediaType()))
            .build()
            .create(CoingeckoApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: CoingeckoApi): CoinRepository {
        return CoinRepositoryImpl(api)
    }
}