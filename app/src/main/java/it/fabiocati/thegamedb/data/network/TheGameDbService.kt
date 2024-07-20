package it.fabiocati.thegamedb.data.network

import it.fabiocati.thegamedb.data.model.GameDataModel
import it.fabiocati.thegamedb.data.model.GameDetailsDataModel
import it.fabiocati.thegamedb.data.model.ImageDataModel
import it.fabiocati.thegamedb.data.model.PopularityPrimitiveDataModel

interface TheGameDbService {
    suspend fun getGames(limit: Int, offset: Int, gameIds: List<Int>): List<GameDataModel>
    suspend fun getGameDetail(gameId: Int): GameDetailsDataModel
    suspend fun getCovers(vararg coverIds: Int): List<ImageDataModel>
    suspend fun getScreenshots(vararg screenshotIds: Int): List<ImageDataModel>
    suspend fun getArtworks(vararg artworksIds: Int): List<ImageDataModel>
    suspend fun getPopular(popularityType: Int, sort: String, limit: Int): List<PopularityPrimitiveDataModel>
}