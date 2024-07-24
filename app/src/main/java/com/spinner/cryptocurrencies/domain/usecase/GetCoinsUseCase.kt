package com.spinner.cryptocurrencies.domain.usecase

import com.spinner.cryptocurrencies.common.ResourceState
import com.spinner.cryptocurrencies.domain.model.Coin
import com.spinner.cryptocurrencies.domain.repository.CoinRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<ResourceState<List<Coin>>> = flow {
        try {
            emit(ResourceState.Loading())
            val coins = repository.getCoins()
            emit(ResourceState.Success(coins))
        } catch(e: HttpException) {
            emit(ResourceState.Error(message = e.localizedMessage ?: "An unexpected error occured"))
        } catch(e: IOException) {
            emit(ResourceState.Error(message = "Couldn't reach server. Check your internet connection."))
        }
    }.flowOn(Dispatchers.IO)
}