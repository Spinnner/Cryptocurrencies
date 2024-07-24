package com.spinner.cryptocurrencies.domain.usecase

import com.spinner.cryptocurrencies.common.ResourceState
import com.spinner.cryptocurrencies.domain.model.CoinDetails
import com.spinner.cryptocurrencies.domain.repository.CoinRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinDetailsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<ResourceState<CoinDetails>> = flow {
        try {
            emit(ResourceState.Loading())
            val coin = repository.getCoinDetails(coinId)
            emit(ResourceState.Success(coin))
        } catch(e: HttpException) {
            emit(ResourceState.Error(message = e.localizedMessage ?: "An unexpected error occured"))
        } catch(e: IOException) {
            emit(ResourceState.Error(message = "Couldn't reach server. Check your internet connection."))
        }
    }.flowOn(Dispatchers.IO)
}