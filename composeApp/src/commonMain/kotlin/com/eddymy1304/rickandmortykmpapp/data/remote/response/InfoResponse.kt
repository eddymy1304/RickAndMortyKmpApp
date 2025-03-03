package com.eddymy1304.rickandmortykmpapp.data.remote.response

import kotlinx.serialization.Serializable

@Serializable
data class InfoResponse(
    var count: Int? = null,
    var next: String? = null,
    var pages: Int? = null,
    var prev: String? = null
)