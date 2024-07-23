package it.fabiocati.thegamedb.data.network

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.HttpMethod
import io.ktor.http.URLProtocol
import io.ktor.http.path
import it.fabiocati.thegamedb.data.model.CompanyDataModel
import it.fabiocati.thegamedb.data.model.GameDataModel
import it.fabiocati.thegamedb.data.model.GameDetailsDataModel
import it.fabiocati.thegamedb.data.model.ImageDataModel
import it.fabiocati.thegamedb.data.model.InvolvedCompanyDataModel
import it.fabiocati.thegamedb.data.model.PopularityPrimitiveDataModel

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

            setBody("fields id,cover,name,screenshots,artworks,involved_companies; limit $limit; offset $offset; sort rating desc;$whereString")
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
            setBody("fields *; where id = (${idsString}); limit 500;")
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

    override suspend fun getArtworks(vararg artworksIds: Int): List<ImageDataModel> {
        val result = httpClient.post {
            method = HttpMethod.Post
            this.url {
                protocol = URLProtocol.HTTPS
                host = "api.igdb.com"
                path("v4/artworks")
            }
            val idsString = artworksIds.fold("") { old, new -> if (old.isNotBlank()) "$old,$new" else "$new" }
            setBody("fields *; where id = (${idsString}); limit 500;")
        }
        return result.body()
    }

    override suspend fun getInvolvedCompanies(vararg involvedCompaniesIds: Int): List<InvolvedCompanyDataModel> {
        val result = httpClient.post {
            method = HttpMethod.Post
            this.url {
                protocol = URLProtocol.HTTPS
                host = "api.igdb.com"
                path("v4/involved_companies")
            }
            val idsString = involvedCompaniesIds.fold("") { old, new -> if (old.isNotBlank()) "$old,$new" else "$new" }
            setBody("fields *; where id = (${idsString}); limit 500;")
        }
        return result.body()
    }

    override suspend fun getCompanies(vararg companiesIds: Int): List<CompanyDataModel> {
        val result = httpClient.post {
            method = HttpMethod.Post
            this.url {
                protocol = URLProtocol.HTTPS
                host = "api.igdb.com"
                path("v4/companies")
            }
            val idsString = companiesIds.fold("") { old, new -> if (old.isNotBlank()) "$old,$new" else "$new" }
            setBody("fields *; where id = (${idsString}); limit 500;")
        }
        return result.body()
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
}