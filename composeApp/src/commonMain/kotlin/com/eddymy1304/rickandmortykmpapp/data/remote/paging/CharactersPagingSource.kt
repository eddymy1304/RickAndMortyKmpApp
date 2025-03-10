package com.eddymy1304.rickandmortykmpapp.data.remote.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.eddymy1304.rickandmortykmpapp.data.remote.ApiService
import com.eddymy1304.rickandmortykmpapp.domain.mapper.toDomainFromResponse
import com.eddymy1304.rickandmortykmpapp.domain.model.CharacterModel

class CharactersPagingSource(private val apiService: ApiService) :
    PagingSource<Int, CharacterModel>() {
    override fun getRefreshKey(state: PagingState<Int, CharacterModel>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CharacterModel> {
        return try {
            val page = params.key ?: 1
            val response = apiService.getAllCharacters(page)
            val characters = response.results

            val prev = if (page == 1) null else page - 1
            val next = if (response.info.next != null) page + 1 else null

            LoadResult.Page(
                data = characters.toDomainFromResponse(),
                prevKey = prev,
                nextKey = next
            )

        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}