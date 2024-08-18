package it.fabiocati.thegamedb.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SimilarGamesDataModel(
    @SerialName("id")
    val id: Int,
    @SerialName("similar_games")
    val similarGames: List<GameDataModel> = emptyList(),
)