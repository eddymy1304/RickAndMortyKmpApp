package com.eddymy1304.rickandmortykmpapp.domain.model

data class EpisodeModel(
    val id: Int,
    val name: String,
    val characters: List<Int>,
    val episode: String,
    val videoUrl: String,
    val season: SeasonEpisode
)

enum class SeasonEpisode {
    SEASON_1,
    SEASON_2,
    SEASON_3,
    SEASON_4,
    SEASON_5,
    SEASON_6,
    SEASON_7,
    SEASON_8,
    UNKNOWN
}