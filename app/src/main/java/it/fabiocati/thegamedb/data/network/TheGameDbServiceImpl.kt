package it.fabiocati.thegamedb.data.network

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.HttpMethod
import io.ktor.http.URLProtocol
import io.ktor.http.path
import it.fabiocati.thegamedb.data.model.GameDataModel
import it.fabiocati.thegamedb.data.model.GameDetailsDataModel

internal class TheGameDbServiceImpl(
    private val httpClient: HttpClient
) : TheGameDbService {

    override suspend fun getGames(limit: Int, offset: Int): List<GameDataModel> {
        val result = httpClient.post {
            method = HttpMethod.Post
            this.url {
                protocol = URLProtocol.HTTPS
                host = "api.igdb.com"
                path("v4/games")
            }
            setBody("fields id,cover,name; limit $limit; offset $offset;")
        }
        return result.body()
    }


    override suspend fun getGameDetail(gameId: Int): GameDetailsDataModel {
        TODO("Not yet implemented")
    }
}