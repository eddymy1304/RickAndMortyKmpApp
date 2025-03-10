package com.eddymy1304.rickandmortykmpapp.data.remote.response

import kotlinx.serialization.Serializable

@Serializable
data class GetAllEpisodesResponse(
    val info: InfoResponse,
    val results: List<EpisodeResponse>
)