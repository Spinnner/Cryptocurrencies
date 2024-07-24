package com.spinner.cryptocurrencies.di

import com.spinner.cryptocurrencies.common.Constants
import com.spinner.cryptocurrencies.data.remote.CoingeckoApi
import com.spinner.cryptocurrencies.data.repository.CoinRepositoryImpl
import com.spinner.cryptocurrencies.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder().addInterceptor(interceptor).build()
    }

    @Provides
    @Singleton
    fun providePaprikaApi(client: OkHttpClient): CoingeckoApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoingeckoApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: CoingeckoApi): CoinRepository {
        return CoinRepositoryImpl(api)
    }
}