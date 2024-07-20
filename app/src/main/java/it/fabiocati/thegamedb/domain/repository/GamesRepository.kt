package it.fabiocati.thegamedb.domain.repository

import it.fabiocati.thegamedb.domain.model.Game

interface GamesRepository {

    suspend fun getGames(limit: Int, offset: Int = 0, gameIds: List<Int> = emptyList()): List<Game>
}