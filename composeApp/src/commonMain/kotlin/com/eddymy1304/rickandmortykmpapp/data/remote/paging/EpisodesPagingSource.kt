package com.eddymy1304.rickandmortykmpapp.data.remote.paging

import androidx.paging.PagingState
import app.cash.paging.PagingSource
import com.eddymy1304.rickandmortykmpapp.data.remote.ApiService
import com.eddymy1304.rickandmortykmpapp.domain.mapper.toDomainFromResponse
import com.eddymy1304.rickandmortykmpapp.domain.model.EpisodeModel

class EpisodesPagingSource(
    private val apiService: ApiService
) : PagingSource<Int, EpisodeModel>() {
    override fun getRefreshKey(state: PagingState<Int, EpisodeModel>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, EpisodeModel> {
        return try {
            val page = params.key ?: 1

            val response = apiService.getAllEpisodes(page)
            val episodes = response.results

            val prev = if (page > 1) page - 1 else null
            val next = if (response.info.next != null) page + 1 else null

            LoadResult.Page(
                prevKey = prev,
                nextKey = next,
                data = episodes.toDomainFromResponse()
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}