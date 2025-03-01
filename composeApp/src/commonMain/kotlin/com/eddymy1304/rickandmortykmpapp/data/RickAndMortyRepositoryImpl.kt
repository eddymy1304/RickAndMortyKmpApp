package com.eddymy1304.rickandmortykmpapp.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.eddymy1304.rickandmortykmpapp.data.remote.ApiService
import com.eddymy1304.rickandmortykmpapp.data.remote.paging.CharactersPagingSource
import com.eddymy1304.rickandmortykmpapp.domain.RickAndMortyRepository
import com.eddymy1304.rickandmortykmpapp.domain.mapper.toDomain
import com.eddymy1304.rickandmortykmpapp.domain.model.CharacterModel
import io.ktor.client.call.DoubleReceiveException
import io.ktor.client.call.NoTransformationFoundException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class RickAndMortyRepositoryImpl(
    private val apiService: ApiService,
    private val charactersPagingSource: CharactersPagingSource
) : RickAndMortyRepository {

    companion object {
        const val PAGE_SIZE = 20
        const val PREFETCH_DISTANCE = 5
    }

    override suspend fun getSingleCharacter(id: Int): Result<CharacterModel> {
        return try {
            val response = withContext(Dispatchers.IO) {
                apiService
                    .getSingleCharacter(id = id)
                    .toDomain()
            }
            Result.success(response)
        } catch (e: DoubleReceiveException) {
            Result.failure(e)
        } catch (e: NoTransformationFoundException) {
            Result.failure(e)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override fun getAllCharacters(page: Int): Flow<PagingData<CharacterModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = PAGE_SIZE,
                prefetchDistance = PREFETCH_DISTANCE,
            ),
            pagingSourceFactory = { charactersPagingSource }

        ).flow
    }
}