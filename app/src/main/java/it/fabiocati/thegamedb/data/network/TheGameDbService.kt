package it.fabiocati.thegamedb.data.network

import it.fabiocati.thegamedb.data.model.GameDataModel
import it.fabiocati.thegamedb.data.model.GameDetailsDataModel
import it.fabiocati.thegamedb.data.model.PopularityPrimitiveDataModel

interface TheGameDbService {
    suspend fun getGames(limit: Int, offset: Int, gameIds: List<Int>): List<GameDataModel>
    suspend fun getSimilarGames(gameId: Int): List<GameDataModel>
    suspend fun getGameDetail(gameId: Int): GameDetailsDataModel
    suspend fun getPopular(popularityType: Int, sort: String, limit: Int): List<PopularityPrimitiveDataModel>
}