package it.fabiocati.thegamedb.data.network

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.HttpMethod
import io.ktor.http.URLProtocol
import io.ktor.http.path
import it.fabiocati.thegamedb.data.model.EventDataModel
import it.fabiocati.thegamedb.data.model.GameDataModel
import it.fabiocati.thegamedb.data.model.GameDetailsDataModel
import it.fabiocati.thegamedb.data.model.PopularityPrimitiveDataModel
import it.fabiocati.thegamedb.data.model.SimilarGamesDataModel

internal class TheGameDbServiceImpl(
    private val httpClient: HttpClient
) : TheGameDbService {

    override suspend fun getGames(
        limit: Int,
        offset: Int,
        gameIds: List<Int>,
    ): List<GameDataModel> {

        val result = httpClient.post {
            method = HttpMethod.Post
            this.url {
                protocol = URLProtocol.HTTPS
                host = "api.igdb.com"
                path("v4/games")
            }

            val whereString = buildString {
                if (gameIds.isNotEmpty()) {
                    val gamesIdsString = gameIds.fold("") { old, new -> if (old.isNotBlank()) "$old,$new" else "$new" }
                    append(" where id = ($gamesIdsString);")
                }
            }

            setBody("fields id ,cover.*, name, screenshots.*,artworks.* ,involved_companies.company.*,involved_companies.developer, involved_companies.game,first_release_date; limit $limit; offset $offset; sort rating desc;$whereString")
        }
        return result.body()
    }

    override suspend fun getSimilarGames(gameId: Int): List<GameDataModel> {
        val result = httpClient.post {
            method = HttpMethod.Post
            this.url {
                protocol = URLProtocol.HTTPS
                host = "api.igdb.com"
                path("v4/games")
            }
            setBody(
                """
                fields 
                    id,
                    similar_games.cover.*, 
                    similar_games.name;
                where 
                    id = $gameId; 
                limit 1;""".trimIndent()
            )
        }
        val mainGame = result.body<List<SimilarGamesDataModel>>().first()
        return mainGame.similarGames
    }


    override suspend fun getGameDetail(gameId: Int): GameDetailsDataModel {
        val result = httpClient.post {
            method = HttpMethod.Post
            this.url {
                protocol = URLProtocol.HTTPS
                host = "api.igdb.com"
                path("v4/games")
            }
            setBody(
                """
                fields 
                    id,
                    name,
                    cover.*,
                    artworks.*,
                    involved_companies.company.*,
                    involved_companies.developer,
                    involved_companies.game,
                    platforms.*,
                    websites.*,
                    videos.*,
                    storyline,
                    summary,
                    first_release_date; 
                where 
                    id = $gameId; 
                limit 1;""".trimIndent()
            )
        }
        return result.body<List<GameDetailsDataModel>>().first()
    }

    override suspend fun getPopular(popularityType: Int, sort: String, limit: Int): List<PopularityPrimitiveDataModel> {
        val result = httpClient.post {
            method = HttpMethod.Post
            this.url {
                protocol = URLProtocol.HTTPS
                host = "api.igdb.com"
                path("v4/popularity_primitives")
            }
            assert(sort == "asc" || sort == "desc")
            setBody("fields *; sort value $sort; limit $limit; where popularity_type = $popularityType;")
        }
        return result.body()
    }

    override suspend fun getEvents(gameId: Int): List<EventDataModel> {
        val result = httpClient.post {
            method = HttpMethod.Post
            this.url {
                protocol = URLProtocol.HTTPS
                host = "api.igdb.com"
                path("v4/events")
            }
            setBody(
                """
                fields 
                    *,
                    event_logo.*; 
                where 
                    games = ($gameId); 
                limit 10;""".trimIndent()
            )
        }
        return result.body<List<EventDataModel>>()
    }
}