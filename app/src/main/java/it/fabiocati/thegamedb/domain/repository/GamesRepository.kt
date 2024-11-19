package it.fabiocati.thegamedb.domain.repository

import it.fabiocati.thegamedb.domain.model.Game
import it.fabiocati.thegamedb.domain.model.GameDetails

interface GamesRepository {

    suspend fun getGames(limit: Int, offset: Int = 0, gameIds: List<Int> = emptyList()): List<Game>
    suspend fun getGameDetails(gameId: Int): GameDetails
    suspend fun getSimilarGames(gameId: Int): List<Game>
}