package it.fabiocati.thegamedb.data.network

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.HttpMethod
import io.ktor.http.URLProtocol
import io.ktor.http.path
import it.fabiocati.thegamedb.data.model.ImageDataModel
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
            setBody("fields id,cover,name,screenshots; limit $limit; offset $offset;")
        }
        return result.body()
    }


    override suspend fun getGameDetail(gameId: Int): GameDetailsDataModel {
        TODO("Not yet implemented")
    }

    override suspend fun getCovers(vararg coverIds: Int): List<ImageDataModel> {
        val result = httpClient.post {
            method = HttpMethod.Post
            this.url {
                protocol = URLProtocol.HTTPS
                host = "api.igdb.com"
                path("v4/covers")
            }
            val idsString = coverIds.fold("") { old, new -> if (old.isNotBlank()) "$old,$new" else "$new" }
            setBody("fields *; where id = (${idsString});")
        }
        return result.body()
    }

    override suspend fun getScreenshots(vararg screenshotIds: Int): List<ImageDataModel> {
        val result = httpClient.post {
            method = HttpMethod.Post
            this.url {
                protocol = URLProtocol.HTTPS
                host = "api.igdb.com"
                path("v4/screenshots")
            }
            val idsString = screenshotIds.fold("") { old, new -> if (old.isNotBlank()) "$old,$new" else "$new" }
            setBody("fields *; where id = (${idsString}); limit 500;")
        }
        return result.body()
    }
}