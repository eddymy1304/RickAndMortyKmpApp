package com.eddymy1304.rickandmortykmpapp.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.eddymy1304.rickandmortykmpapp.data.database.RickAndMortyDatabase
import com.eddymy1304.rickandmortykmpapp.data.database.entity.CharacterEntity
import com.eddymy1304.rickandmortykmpapp.data.remote.ApiService
import com.eddymy1304.rickandmortykmpapp.data.remote.paging.CharactersPagingSource
import com.eddymy1304.rickandmortykmpapp.domain.RickAndMortyRepository
import com.eddymy1304.rickandmortykmpapp.domain.mapper.toDomainFromEntity
import com.eddymy1304.rickandmortykmpapp.domain.mapper.toDomainFromResponse
import com.eddymy1304.rickandmortykmpapp.domain.model.CharacterModel
import com.eddymy1304.rickandmortykmpapp.domain.model.CharacterOfTheDayModel
import io.ktor.client.call.DoubleReceiveException
import io.ktor.client.call.NoTransformationFoundException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class RickAndMortyRepositoryImpl(
    private val apiService: ApiService,
    private val charactersPagingSource: CharactersPagingSource,
    private val rickAndMortyDatabase: RickAndMortyDatabase
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
                    .toDomainFromResponse()
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

    override fun getAllCharacters(): Flow<PagingData<CharacterModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = PAGE_SIZE,
                prefetchDistance = PREFETCH_DISTANCE,
            ),
            pagingSourceFactory = { charactersPagingSource }

        ).flow
    }

    override suspend fun getCharacterOfTheDayDb(): CharacterOfTheDayModel? {
        return rickAndMortyDatabase
            .getUserPreferencesCharacterDao()
            .getCharacterOfTheDayDb()
            ?.toDomainFromEntity()
    }

    override suspend fun saveCharacterOfTheDayDb(entity: CharacterEntity) {
        rickAndMortyDatabase
            .getUserPreferencesCharacterDao()
            .saveCharacterOfTheDayDb(entity)
    }
}