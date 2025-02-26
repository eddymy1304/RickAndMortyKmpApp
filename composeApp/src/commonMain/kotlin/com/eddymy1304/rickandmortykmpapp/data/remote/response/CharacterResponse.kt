package com.eddymy1304.rickandmortykmpapp.data.remote.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CharacterResponse(
    var created: String? = null,
    var episode: List<String>? = null,
    var gender: String? = null,
    @SerialName("id") var id: Int? = null,
    var image: String? = null,
    var location: Location? = null,
    var name: String? = null,
    var origin: Origin? = null,
    var species: String? = null,
    var status: String? = null,
    var type: String? = null,
    var url: String? = null
) {
    @Serializable
    data class Location(
        var name: String? = null,
        var url: String? = null
    )

    @Serializable
    data class Origin(
        var name: String? = null,
        var url: String? = null
    )
}