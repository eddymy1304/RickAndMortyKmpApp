package com.eddymy1304.rickandmortykmpapp.domain.mapper

import com.eddymy1304.rickandmortykmpapp.data.remote.response.EpisodeResponse
import com.eddymy1304.rickandmortykmpapp.domain.model.EpisodeModel
import com.eddymy1304.rickandmortykmpapp.domain.model.SeasonEpisode

object EpisodeMapper : ResponseToDomainMapper<EpisodeResponse, EpisodeModel> {

    private fun getSeasonFromEpisodeCode(episode: String?): SeasonEpisode {
        if (episode == null) return SeasonEpisode.UNKNOWN
        return when {
            episode.startsWith("S01") -> SeasonEpisode.SEASON_1
            episode.startsWith("S02") -> SeasonEpisode.SEASON_2
            episode.startsWith("S03") -> SeasonEpisode.SEASON_3
            episode.startsWith("S04") -> SeasonEpisode.SEASON_4
            episode.startsWith("S05") -> SeasonEpisode.SEASON_5
            episode.startsWith("S06") -> SeasonEpisode.SEASON_6
            episode.startsWith("S07") -> SeasonEpisode.SEASON_7
            episode.startsWith("S08") -> SeasonEpisode.SEASON_8
            else -> SeasonEpisode.UNKNOWN
        }
    }

    private fun getVideoUrlFromSeason(season: SeasonEpisode): String {
        return when (season) {
            SeasonEpisode.SEASON_1 -> "https://www.youtube.com/watch?v=8BEzj2kRjO8&ab_channel=RottenTomatoesTV"
            SeasonEpisode.SEASON_2 -> "https://www.youtube.com/watch?v=SXwf_9xJu5c&ab_channel=Yusuto"
            SeasonEpisode.SEASON_3 -> "https://www.youtube.com/watch?v=Bmg2vXOQ3kM&ab_channel=SeriesTrailerMP"
            SeasonEpisode.SEASON_4 -> "https://www.youtube.com/watch?v=bLI2-v264No&ab_channel=RottenTomatoesTV"
            SeasonEpisode.SEASON_5 -> "https://www.youtube.com/watch?v=yC1UxW8vcDo&ab_channel=RottenTomatoesTV"
            SeasonEpisode.SEASON_6 -> "https://www.youtube.com/watch?v=jerFRSQW9g8&ab_channel=RottenTomatoesTV"
            SeasonEpisode.SEASON_7 -> "https://www.youtube.com/watch?v=PkZtVBNkmso&ab_channel=RottenTomatoesTV"
            SeasonEpisode.SEASON_8 -> "https://www.youtube.com/watch?v=EWSaCitNyIs"
            SeasonEpisode.UNKNOWN -> ""
        }
    }

    override fun toDomainFromResponse(response: EpisodeResponse): EpisodeModel {
        val season = getSeasonFromEpisodeCode(response.episode)
        return EpisodeModel(
            id = response.id ?: -1,
            name = response.name.orEmpty(),
            videoUrl = getVideoUrlFromSeason(season),
            episode = response.episode.orEmpty(),
            characters = response.characters
                ?.map { it.substringAfterLast("/").toInt() }
                ?: listOf(),
            season = season
        )
    }
}

fun EpisodeResponse.toDomainFromResponse() = EpisodeMapper.toDomainFromResponse(this)

fun List<EpisodeResponse>.toDomainFromResponse() = this.map { it.toDomainFromResponse() }