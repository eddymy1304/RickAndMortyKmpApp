package com.eddymy1304.rickandmortykmpapp.data.remote.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class EpisodeResponse(
    @SerialName("air_date")var airDate: String? = null,
    var characters: List<String>? = null,
    var created: String? = null,
    var episode: String? = null,
    var id: Int? = null,
    var name: String? = null,
    var url: String? = null
)