package it.fabiocati.thegamedb.data.network

import it.fabiocati.thegamedb.data.model.GameDataModel
import it.fabiocati.thegamedb.data.model.GameDetailsDataModel

interface TheGameDbService {
    suspend fun getGames(limit: Int = 10, offset: Int = 0): List<GameDataModel>
    suspend fun getGameDetail(gameId: Int): GameDetailsDataModel
}